package com.shiki.controller;

import com.github.pagehelper.PageInfo;
import com.shiki.common.Enum.Message;
import com.shiki.common.result.Result;
import com.shiki.domain.dto.SText;
import com.shiki.service.TextService;
import com.shiki.vo.LayuiTableVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * 分页查询全部文章
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequiresAuthentication
    @GetMapping("/findAll")
    @ResponseBody
    public Result findAll(@RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize) {
        if (pageNum == null
                || pageSize == null
                || StringUtils.isBlank(pageNum.toString())
                || StringUtils.isBlank(pageSize.toString())) {
            return new Result(false, Message.FAILURE, "文章id或删除状态为空");
        }

        PageInfo<SText> textList;
        boolean root = SecurityUtils.getSubject().hasRole("root");

        textList = textService.findAll(pageNum, pageSize, root);
        LayuiTableVo layuiTableVo = new LayuiTableVo(textList.getList(), textList.getTotal());

        return Result.builder()
                .success(true)
                .msg(Message.SUCCESS)
                .data(layuiTableVo)
                .build();
    }

    /**
     * 根据文章id判断是否删除文章，只有root用户可以对文章进行操作
     *
     * @param textId
     * @param isDelete
     * @return
     */
    @RequiresRoles("root")
    @GetMapping("/rootUpdateById")
    @ResponseBody
    public Result rootUpdateById(Long textId, Boolean isDelete) {
        //todo:可以使用aop对参数统一进行非空校验
        if (textId == null
                || isDelete == null
                || StringUtils.isBlank(textId.toString())
                || StringUtils.isBlank(isDelete.toString())) {
            return new Result(false, Message.FAILURE, "文章id或删除状态为空");
        }

        try {
            int i = textService.rootUpdateById(textId, isDelete);
            if (i<=0){
                return new Result(false, Message.FAILURE, "该文章不存在");
            }
            return new Result(true, Message.SUCCESS, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, Message.FAILURE, null);
    }
}
