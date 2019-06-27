package com.shiki.service.impl;

import com.shiki.common.util.MD5util;
import com.shiki.domain.dao.SUserMapper;
import com.shiki.domain.dto.SUser;
import com.shiki.domain.dto.SUserExample;
import com.shiki.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 孙磊
 * @description
 * @date 2019/6/20 18:37
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SUserMapper userMapper;

    @Override
    public SUser findOneByUserId(Long uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public SUser findOneByUsername(String username) {
        SUserExample example = new SUserExample();
        example.createCriteria()
                .andUsernameEqualTo(username);
        List<SUser> list = userMapper.selectByExample(example);

        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public SUser login(Integer mark, SUser user) {
        String username;
        String password;
        switch (mark) {
            case 1: {
                username = "root";
                password = "1";
            }
            break;
            case 2: {
                username = "test_user";
                password = "123456";
            }
            break;
            case 3: {
                username = "user1";
                password = "1";
            }
            break;
            default:
                return null;
        }
        password = MD5util.encrypt(username, password);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
