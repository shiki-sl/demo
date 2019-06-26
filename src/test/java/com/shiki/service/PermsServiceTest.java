package com.shiki.service;

import com.github.pagehelper.PageInfo;
import com.shiki.domain.dto.SText;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;

/**
 * @author 孙磊
 * @description
 * @date 2019/6/21 15:13
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class PermsServiceTest {

    @Autowired
    private PermsService permsService;

    @Autowired
    private TextService textService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Test
    public void findAllByRoleId() {
        permsService.findAllByRoleId(1).forEach(System.out::println);
    }

    @Test
    public void findOneByTestId() {
        System.out.println(textService.findOneByTestId(2));
    }


    @Test
    public void findAll() {
        PageInfo<SText> page = textService.findAll(1, 10,true);
        System.out.println(page);
        page.getList().forEach(System.out::println);
    }


    @Test
    public void findPermsByUserId() {
//        roleService.findAllByUserId(1).forEach(System.out::println);
        permsService.findPermsByUserId(1).forEach(System.out::println);
    }

    @Test
    public void m() {
        System.out.println(System.currentTimeMillis());
    }
}