package com.shiki.controller;

import com.shiki.common.Enum.Message;
import com.shiki.common.result.Result;
import com.shiki.domain.dto.SUser;
import com.shiki.service.RoleService;
import com.shiki.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙磊
 * @description
 * @date 2019/6/20 18:47
 */
@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 根据用户id查看用户详细信息，只有拥有test权限角色可以访问到
     *
     * @param userId
     * @return
     */
    @RequiresRoles("test")
    @GetMapping("/findOneByUserId/{userId}")
    @ResponseBody
    public Result findOneByUserId(@PathVariable Integer userId) {
        if (userId == null
                || StringUtils.isBlank(userId.toString())) {
            return new Result(false, Message.FAILURE, "文章id或删除状态为空");
        }

        SUser user = userService.findOneByUserId(userId);
        if (user != null) {
            return new Result(true, Message.SUCCESS, user);
        }
        return new Result(false, Message.FAILURE, null);
    }

    /**
     * 测试
     *
     * @return
     */
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "index";
    }


///    /**
//     * 根据用户id查询用户所拥有的角色,只有root角色可以访问
//     * @param userId
//     * @return
//     */
//    @RequiresRoles("root")
//    @GetMapping("/findAllRoleByUserId/{userId}")
//    @ResponseBody
//    public Result findAllRoleByUserId(@PathVariable Integer userId) {
//        List<SRole> roleList = roleService.findAllByUserId(userId);
//        return new Result(true, Message.SUCCESS, roleList);
//    }

    /**
     * 根据mark模拟登陆
     *
     * @param mark
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(Integer mark, ModelAndView mv) {
        Map<String, String> map = new HashMap<>(16);
        if (mark == null
                || StringUtils.isBlank(mark.toString())) {
            map.put("未登录,请登录", "");
            mv.setViewName("login");
            mv.addAllObjects(map);
            return mv;
        }
        map = userService.login(mark, map);

        mv.setViewName("index");
        mv.addAllObjects(map);
        return mv;
    }

    /**
     * 登出
     *
     * @return
     */
    @RequiresAuthentication
    @RequestMapping("/logout")
    public String logout() {
        if (SecurityUtils.getSubject().getPrincipal() != null) {
            String logout = "当前用户" + SecurityUtils.getSubject().getPrincipal() + "已退出登录";
            SecurityUtils.getSubject().logout();
            log.info(logout);
            return "login";
        }
        return "login";
    }
}
