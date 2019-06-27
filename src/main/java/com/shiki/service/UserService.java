package com.shiki.service;

import com.shiki.domain.dto.SUser;

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
    SUser findOneByUserId(Long uid);

    /**
     *
     * @param username
     * @return
     */
    SUser findOneByUsername(String username);

    /**
     *
     * @param mark
     * @param user
     * @return
     */
    SUser login(Integer mark, SUser user);
}
