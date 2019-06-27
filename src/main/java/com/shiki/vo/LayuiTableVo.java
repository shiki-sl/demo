package com.shiki.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 孙磊
 * @description layui表格视图
 * @date 2019/6/27 11:13
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LayuiTableVo {
    /**
     * 返回数据的list集合
     */
    private List list;

    /**
     * 返回数据库中符合要求的总数据量
     */
    private Long count;
}
