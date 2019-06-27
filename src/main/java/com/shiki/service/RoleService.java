package com.shiki.service;

import com.shiki.domain.dto.SRole;

import java.util.List;

/**
 * @author 孙磊
 * @description
 * @date 2019/6/20 18:37
 */
public interface RoleService {

     List<SRole> findAllByUserId(Integer userId);
}
