package com.shiki.service.impl;

import com.shiki.domain.dao.SRoleExtMapper;
import com.shiki.domain.dao.SRoleMapper;
import com.shiki.domain.dto.SRole;
import com.shiki.domain.dto.SRoleExample;
import com.shiki.domain.dto.SUser;
import com.shiki.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 孙磊
 * @description
 * @date 2019/6/20 18:37
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private SRoleExtMapper sRoleExtMapper;

    @Override
    public List<SRole> findAllByUserId(Integer userId){
        return sRoleExtMapper.findAllByUserId(userId);
    }
}
