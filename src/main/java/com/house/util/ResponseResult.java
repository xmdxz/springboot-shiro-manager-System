package com.house.util;


import lombok.Data;

/**
 * @Author xpdxz
 * @ClassName ResponseResult
 * @Description TODO
 * @Date 2022/1/8 12:28
 */
@Data
public class ResponseResult {

    private int status;

    private String msg;

    private Object data;

    private ResponseResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ResponseResult(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseResult ok() {
        return new ResponseResult(200, "成功");
    }

    public static <T> ResponseResult ok(T data) {
        return new ResponseResult(200, "成功", data);
    }

    public static ResponseResult ok(String msg) {
        return new ResponseResult(200, msg);
    }

    public static <T> ResponseResult ok(String msg, T data) {
        return new ResponseResult(200, msg, data);
    }


    public static ResponseResult error(int status, String msg) {
        return new ResponseResult(status, msg);
    }

    public static <T> ResponseResult error(int status, String msg, T data) {
        return new ResponseResult(status, msg, data);
    }

    public static <T> ResponseResult other(int status, String msg, T data) {
        return new ResponseResult(status, msg, data);
    }

    public static ResponseResult other(int status, String msg) {
        return new ResponseResult(status, msg);
    }

}
