package com.shiki.controller;

import com.github.pagehelper.PageInfo;
import com.shiki.common.Enum.Message;
import com.shiki.common.result.LayUiResult;
import com.shiki.common.result.Result;
import com.shiki.domain.dto.SText;
import com.shiki.service.TextService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 孙磊
 * @description 文章管理
 * @date 2019/6/23 16:22
 */
@Controller
@RequestMapping("/text")
public class TextController {
    @Autowired
    private TextService textService;

    @RequiresAuthentication
    @GetMapping("/findAll")
    @ResponseBody
    public LayUiResult findAll(@RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize) {
        PageInfo<SText> textList;
        boolean root = SecurityUtils.getSubject().hasRole("root");
        textList = textService.findAll(pageNum, pageSize, root);
        return LayUiResult.builder()
                .code(0)
                .msg("success")
                .count(textList.getTotal())
                .data(textList.getList())
                .build();
    }

    @RequiresRoles("root")
    @GetMapping("/updateById")
    @ResponseBody
    public Result updateById(Integer textId,Boolean isDelete){
        try {
            textService.updateById(textId,isDelete);
            return new Result(true, Message.SUCCESS,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, Message.FAILURE,null);
    }
}
