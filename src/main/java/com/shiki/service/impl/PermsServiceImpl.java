package com.shiki.service.impl;

import com.shiki.domain.dao.SPermsExtMapper;
import com.shiki.domain.dao.SPermsMapper;
import com.shiki.domain.dto.SPerms;
import com.shiki.domain.dto.SRole;
import com.shiki.service.PermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 孙磊
 * @description
 * @date 2019/6/20 18:37
 */
@Service
public class PermsServiceImpl implements PermsService {
    @Autowired
    private SPermsExtMapper permsExtMapper;


    @Override
    public List<SPerms> findAllByRoleId(Integer roleId){
        return permsExtMapper.findAllByRoleId(roleId);
    }

    @Override
    public List<String> findPermsByUserId(Integer userId){
        return permsExtMapper.findPermsByUserId(userId);
    }
}
