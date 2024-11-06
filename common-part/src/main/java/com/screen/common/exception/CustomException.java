package com.screen.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private int code;

    public CustomException(String message, int code) {
        super(message);
        this.code = code;
    }

}