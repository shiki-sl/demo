package com.shiki.service;

import com.shiki.domain.dao.SUserMapper;
import com.shiki.domain.dto.SUser;
import com.shiki.domain.dto.SUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 孙磊
 * @description
 * @date 2019/6/20 18:37
 */
@Service
//@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    private  SUserMapper userMapper;



    public List<SUser> findAll() {
        return userMapper.selectByExample(null);
    }

    public SUser findOneByUserId(Integer uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    public SUser findOneByUsername(String username) {
        SUserExample example = new SUserExample();
        example.createCriteria()
                .andUsernameEqualTo(username);
        List<SUser> list = userMapper.selectByExample(example);

        return list.isEmpty() ? null : list.get(0);
    }


}
