package com.shiki.service;

import com.shiki.domain.dao.SPermsMapper;
import com.shiki.domain.dto.SPerms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 孙磊
 * @description
 * @date 2019/6/20 18:37
 */
@Service
public interface PermsService {



     List<SPerms> findAllByRoleId(Integer roleId);

     List<String> findPermsByUserId(Integer userId);
}
