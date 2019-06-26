package com.shiki.shiro;

import com.shiki.domain.dto.SRole;
import com.shiki.domain.dto.SUser;
import com.shiki.service.PermsService;
import com.shiki.service.RoleService;
import com.shiki.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 孙磊
 * @description shiro效验
 * @date 2019/6/21 9:33
 */
@Configuration
public class AdminRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private PermsService permsService;

    @Autowired
    private RoleService roleService;


    /**
     * 权限配置
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置-->AdminRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SUser userInfo = (SUser) principalCollection.getPrimaryPrincipal();

        List<String> authsUrlList = permsService.findPermsByUserId(userInfo.getUserId());

        Set<String> roles = roleService
                .findAllByUserId(userInfo.getUserId())
                .stream()
                .map(SRole::getRoleName)
                .collect(Collectors.toSet());

        authorizationInfo.addRoles(roles);
        authorizationInfo.addStringPermissions(authsUrlList);
        return authorizationInfo;
    }

    /**
     * 用户验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 将token装换成UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        // 获取用户名即可
        String username = upToken.getUsername();
        // 查询数据库，是否查询到用户名和密码的用户
        SUser userInfo = null;
        if (username == null) {
            return null;
        }
        try {
            userInfo = userService.findOneByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SimpleAuthenticationInfo info = null;
        if (userInfo != null) {
            // 如果查询到了，封装查询结果，返回给我们的调用
            //Object principal = userInfo.getUserName();
            Object userPwd = userInfo.getPassword();

            // 获取盐值，即用户名
            //ByteSource salt = ByteSource.Util.bytes(username);
            String realmName = this.getName();
            // 将账户名，密码，盐值，realmName实例化到SimpleAuthenticationInfo中交给Shiro来管理
            info = new SimpleAuthenticationInfo(userInfo, userPwd, realmName);
        } else {
            // 如果没有查询到，抛出一个异常
            throw new AuthenticationException();
        }
        return info;
    }
}
