package com.shiki.service.impl;

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
//@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private SUserMapper userMapper;

    @Override
    public SUser findOneByUserId(Integer uid) {
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
    public Map<String, String> login(Integer mark, Map<String, String> map) {
        switch (mark) {
            case 1: {
                map.put("username", "root");
                map.put("password", "1");
            }
            break;
            case 2: {
                map.put("username", "test_user");
                map.put("password", "123456");
            }
            break;
            case 3: {
                map.put("username", "user1");
                map.put("password", "1");
            }
            break;
            default:
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(map.get("username"), map.get("password"));
        subject.login(token);
        return map;
    }
}
