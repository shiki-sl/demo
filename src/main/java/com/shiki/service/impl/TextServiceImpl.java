package com.shiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiki.common.Enum.Message;
import com.shiki.common.result.Result;
import com.shiki.domain.dao.STextMapper;
import com.shiki.domain.dto.SText;
import com.shiki.domain.dto.STextExample;
import com.shiki.domain.dto.SUser;
import com.shiki.service.TextService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 孙磊
 * @description
 * @date 2019/6/20 18:37
 */
@Service
public class TextServiceImpl implements TextService {
    @Autowired
    private STextMapper textMapper;

    @Override
    public PageInfo<SText> findAll(Integer pageNum, Integer pageSize, boolean flag) {
        STextExample example = new STextExample();
        if (!flag) {
            example.createCriteria().andIsDeleteEqualTo((byte) 0);
        }

        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(textMapper.selectByExampleWithBLOBs(example));
    }

    @Override
    public SText findOneByTestId(Long textId) {
        STextExample example = new STextExample();
        example.createCriteria()
                .andTextIdEqualTo(textId)
                .andIsDeleteEqualTo((byte) 0);

        List<SText> list = textMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return null;
        }
        return list.get(0);
    }


    @Override
    public int rootUpdateById(Long textId, Boolean isDelete) {
        SText text = textMapper.selectByPrimaryKey(textId);
        if (text == null) {
            return 0;
        }
        text.setUpdateTime(System.currentTimeMillis());
        text.setIsDelete((byte) (isDelete ? 1 : 0));
        return textMapper.updateByPrimaryKey(text);
    }

    @Override
    public Result saveText(SText text) {
        SUser user = (SUser) SecurityUtils.getSubject().getPrincipal();

        //当前登录用户与文章拥有用户不一致
        if (!text.getUserId().equals(user.getUserId())) {
            return new Result(false, Message.FAILURE_NO_PERM, "不是该文章的拥有者无法修改文章");
        }

        //根据textId来判断插入or更新
        if (text.getTextId() == 0L) {
            return insert(text, user.getUserId());
        } else {
            return update(text);
        }
    }


    private Result insert(SText text, Long userId) {
        text.setCreateTime(System.currentTimeMillis());
        text.setUserId(userId);
        textMapper.insertSelective(text);
        return new Result(true, Message.SUCCESS, "插入文章成功");
    }

    private Result update(SText text) {
        text.setUpdateTime(System.currentTimeMillis());
        textMapper.updateByPrimaryKey(text);
        return new Result(true, Message.SUCCESS, "更新文章成功");
    }
}
