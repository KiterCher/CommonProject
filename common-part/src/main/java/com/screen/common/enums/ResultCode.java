package com.screen.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(0, "成功"),
    INTERNAL_SERVER_ERROR(5000, "服务器内部错误"),
    BAD_REQUEST(4000, "错误的请求"),
    UNAUTHORIZED(4001, "未授权"),
    FORBIDDEN(4003, "禁止访问"),
    NOT_FOUND(4004, "未找到"),
    USER_NOT_LOGIN(4400,"用户未登录");

    private final int code;
    private final String message;

}
