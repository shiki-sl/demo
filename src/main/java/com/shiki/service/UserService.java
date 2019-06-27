package com.shiki.service;

import com.shiki.domain.dao.SUserMapper;
import com.shiki.domain.dto.SUser;
import com.shiki.domain.dto.SUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 孙磊
 * @description
 * @date 2019/6/20 18:37
 */
public interface UserService {
    /**
     *
     * @param uid
     * @return
     */
    SUser findOneByUserId(Integer uid);

    /**
     *
     * @param username
     * @return
     */
    SUser findOneByUsername(String username);

    /**
     *
     * @param mark
     * @param map
     * @return
     */
    Map<String, String> login(Integer mark, Map<String, String> map);
}
