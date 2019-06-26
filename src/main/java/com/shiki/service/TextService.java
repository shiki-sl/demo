package com.shiki.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shiki.domain.dao.STextMapper;
import com.shiki.domain.dto.SText;
import com.shiki.domain.dto.STextExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 孙磊
 * @description
 * @date 2019/6/20 18:37
 */
@Service
public class TextService {
    @Autowired
    private STextMapper textMapper;

    /**
     * 分页查询全部
     *
     * @param pageNum  自第几页开始查询
     * @param pageSize 每页展示数量
     * @param flag     是否查询在数据库中被删除的文章,只有root用户可以查询 true未拥有root权限,false为未拥有root权限
     * @return
     */
    public PageInfo<SText> findAll(Integer pageNum, Integer pageSize, boolean flag) {


        STextExample example = new STextExample();
        if (!flag) {
            example.createCriteria().andIsDeleteEqualTo(false);
        }

        PageHelper.startPage(pageNum, pageSize);

        return new PageInfo<>(textMapper.selectByExampleWithBLOBs(example));
    }


    public SText findOneByTestId(Integer textId) {
        STextExample example = new STextExample();
        example.createCriteria()
                .andTextIdEqualTo(textId)
                .andIsDeleteEqualTo(false);

        List<SText> list = textMapper.selectByExample(example);
        return list.isEmpty() ? null : list.get(0);
    }

    public void delByTextId(Integer textId) {
        SText text = findOneByTestId(textId);
        text.setIsDelete(true);
        textMapper.updateByPrimaryKey(text);
    }

    public int updateById(Integer textId, Boolean isDelete) {
        SText text = textMapper.selectByPrimaryKey(textId);
        text.setIsDelete(isDelete);
        return textMapper.updateByPrimaryKey(text);
    }
}
