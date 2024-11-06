package com.screen.common.base;

import com.screen.common.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult<T> {
    private int code;
    private String message;
    private T data;

    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> BaseResult<T> success(String message, T data) {
        return new BaseResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static BaseResult<Void> success(String message) {
        return new BaseResult<>(ResultCode.SUCCESS.getCode(), message, null);
    }

    public static BaseResult<Void> success() {
        return new BaseResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    public static <T> BaseResult<T> error(int code, String message) {
        return new BaseResult<>(code, message, null);
    }

    // Common error responses with error code 500
    public static BaseResult<Void> error() {
        return new BaseResult<>(ResultCode.INTERNAL_SERVER_ERROR.getCode(), ResultCode.INTERNAL_SERVER_ERROR.getMessage(), null);
    }

    public static  BaseResult<Void> error(String message) {
        return new BaseResult<>(ResultCode.INTERNAL_SERVER_ERROR.getCode(), message, null);
    }
}