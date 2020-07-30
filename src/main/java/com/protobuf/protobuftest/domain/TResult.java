package com.protobuf.protobuftest.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by yc
 * 2017-11-23 11:57
 */
@Data

public class TResult<T> implements Serializable {


    private int code;


    private String msg;

    //数据体
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public TResult() {
    }

    public TResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public TResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public static boolean isSucess(int code) {
        return (code == ResultCodeEnum.SUCCESS.getCode());
    }
}