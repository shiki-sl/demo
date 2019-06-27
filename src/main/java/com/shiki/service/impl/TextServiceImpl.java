package com.shiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiki.domain.dao.STextMapper;
import com.shiki.domain.dto.SText;
import com.shiki.domain.dto.STextExample;
import com.shiki.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
