package com.example.warehouse.common;

public class ResultUtil {

    public static <T> Result<T> success() {
        return build(200, "操作成功", null);
    }

    public static <T> Result<T> success(T data) {
        return build(200, "操作成功", data);
    }

    public static <T> Result<T> error(String message) {
        return build(500, message, null);
    }

    public static <T> Result<T> error(int code, String message) {
        return build(code, message, null);
    }

    public static <T> Result<T> build(int code, String message, T data) {
        return new Result<>(code, message, data);
    }
}
