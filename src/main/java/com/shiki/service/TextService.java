package com.shiki.service;

import com.github.pagehelper.PageInfo;
import com.shiki.common.result.Result;
import com.shiki.domain.dto.SText;

/**
 * @author 孙磊
 * @description
 * @date 2019/6/20 18:37
 */
public interface TextService {

    /**
     * 分页查询全部
     *
     * @param pageNum  自第几页开始查询
     * @param pageSize 每页展示数量
     * @param flag     是否查询在数据库中被删除的文章,只有root用户可以查询 true为拥有root权限,false为未拥有root权限
     * @return
     */
    PageInfo<SText> findAll(Integer pageNum, Integer pageSize, boolean flag);

    /**
     * @param textId
     * @return
     */
    SText findOneByTestId(Long textId);


    /**
     * 只有root角色可以查询全部文章 并修改文章的删除状态
     *
     * @param textId
     * @param isDelete true删除,false不删除
     * @return
     */
    int rootUpdateById(Long textId, Boolean isDelete);

    /**
     * 更新文章方法,判断文章id是否存在对文章进行更新
     */
    Result saveText(SText text);
}
