package com.shiki.service;

import com.shiki.domain.dao.SRoleMapper;
import com.shiki.domain.dto.SRole;
import com.shiki.domain.dto.SRoleExample;
import com.shiki.domain.dto.SUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 孙磊
 * @description
 * @date 2019/6/20 18:37
 */
@Service
public class RoleService {
    @Autowired
    private SRoleMapper roleMapper;

    public List<SRole> findAll(){
        return roleMapper.selectByExample(null);
    }

    public List<SRole> findAllByUserId(Integer userId){
        return roleMapper.findAllByUserId(userId);
    }
}
