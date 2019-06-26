package com.shiki.common.result;

import com.shiki.common.Enum.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 孙磊
 * @description 返回结果集
 * @date 2019/6/21 14:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result {
    private boolean success;
    private Message msg;
    private Object data;
}
