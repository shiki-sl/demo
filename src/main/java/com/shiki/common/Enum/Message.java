package com.shiki.common.Enum;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author 孙磊
 * @description 返回信息
 * @date 2019/6/21 14:03
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Message {
    SUCCESS("2000", "操作成功"),
//    SUCCESS_LOGIN("2001","登陆成功"),


    FAILURE("4000","操作失败"),

    FAILURE_NO_PERM("4001","权限不足"),
    ;



    private final String code;
    private final String msg;

    Message (String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

//    @JsonValue
    public String getCode() {
        return code;
    }

//    @JsonValue
    public String getMsg() {
        return msg;
    }
}
