package com.shiki.common.aop;

import com.shiki.common.Enum.Message;
import com.shiki.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;

/**
 * @author 孙磊
 * @description 异常拦截
 * @date 2019/6/25 17:09
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler({AuthorizationException.class})
    public Result noAuthorizationException() {
        log.warn("\r\n该用户无权限:" + SecurityUtils.getSubject().getPrincipal() + "\t操作时间:" + ZonedDateTime.now());
        return new Result(false, Message.FAILURE_NO_PERM, null);
    }

}
