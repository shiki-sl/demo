package com.shiki.controller;

import com.shiki.common.Enum.Message;
import com.shiki.common.result.Result;
import com.shiki.domain.dto.SRole;
import com.shiki.domain.dto.SUser;
import com.shiki.service.RoleService;
import com.shiki.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 孙磊
 * @description
 * @date 2019/6/20 18:47
 */
@Controller
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequiresAuthentication
    @GetMapping("/findAll")
    @ResponseBody
    public Result findAll() {
        List<SUser> userList = userService.findAll();
        return new Result(true, Message.SUCCESS, userList);
    }

    @RequiresRoles("test")
    @GetMapping("/findOneByUserId/{userId}")
    @ResponseBody
    public Result findOneByUserId(@PathVariable Integer userId) {
        SUser user = userService.findOneByUserId(userId);
        if (user != null) {
            return new Result(true, Message.SUCCESS, user);
        }
        return new Result(false, Message.FAILURE, null);
    }


    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "index";
    }

    @RequiresRoles("root")
    @GetMapping("/findAllRoleByUserId/{userId}")
    @ResponseBody
    public Result findAllRoleByUserId(@PathVariable Integer userId) {
        List<SRole> roleList = roleService.findAllByUserId(userId);
        return new Result(true, Message.SUCCESS, roleList);
    }

    /**
     * 根据mark模拟登陆
     *
     * @param mark
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(Integer mark, ModelAndView mv) {
        Map<String, String> map = new HashMap<>(16);
        if (mark == null) {
            map.put("未登录,请登录", "");
            mv.setViewName("login");
            mv.addAllObjects(map);
            return mv;
        }
        switch (mark) {
            case 1: {
                map.put("username", "root");
                map.put("password", "1");
            }
            break;
            case 2: {
                map.put("username", "test_user");
                map.put("password", "123456");
            }
            break;
            case 3: {
                map.put("username", "user1");
                map.put("password", "1");
            }
            break;
            default:
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(map.get("username"), map.get("password"));
        subject.login(token);
        mv.setViewName("index");
        mv.addAllObjects(map);
        return mv;
    }

    //登出
    @RequiresAuthentication
    @RequestMapping("/logout")
    public String logout() {
        if (SecurityUtils.getSubject().getPrincipal() != null) {
            String logout = "当前用户" + SecurityUtils.getSubject().getPrincipal() + "已退出登录";
            SecurityUtils.getSubject().logout();
            log.info(logout);
            return "login";
        }
        return "login";
    }
}
