package com.chenjiacheng.webapp.start.controller.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by chenjiacheng on 2025/2/17 22:57
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
public class Result<T> implements Serializable {

    private String code;

    private String msg;

    private T data;

    public Result() {
    }

    public Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> ofSuccess(T data) {
        return new Result<>("200", "success", data);
    }

    public static <T> Result<T> ofFail(String code, String msg) {
        return new Result<>(code, msg, null);
    }



}
