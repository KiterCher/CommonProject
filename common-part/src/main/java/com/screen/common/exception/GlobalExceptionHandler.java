package com.screen.common.exception;

import com.screen.common.base.BaseResult;
import com.screen.common.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final BaseResult<Void> handleRuntimeExceptions(Exception ex, WebRequest request) {

        BaseResult<Void> result = null;

        if (ex instanceof CustomException) {
            // 处理自定义日常错误
            CustomException normalException = (CustomException) ex;
            result = BaseResult.error(normalException.getCode(), normalException.getMessage());

            // 依据错误打印不同级别日志
            if (result.getCode() == 500) {
                log.warn("系统相关异常", ex);
            } else {
                log.info("用户相关异常", ex);
            }
        } else {
            log.error("系统错误：", ex);
            result = BaseResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统错误！");
        }

        return result;
    }

}