package com.shiki.common.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 孙磊
 * @description layui结果集
 * @date 2019/6/23 16:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LayUiResult {
    private Integer code;
    private String msg;
    private Long count;
    private Object data;
}
