package com.shiki.common.util;

import org.springframework.util.DigestUtils;

/**
 * @author 孙磊
 * @description MD5加密
 * @date 2019/6/27 15:37
 */
public class MD5util {

    public static String encrypt(String username, String password) {
        return DigestUtils.md5DigestAsHex(("shiki-demo-user-username:" + username + "&password:" + password).getBytes());
    }

}
