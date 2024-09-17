package com.xiaohan.demo.spring.mvc.exception;

import com.xiaohan.demo.spring.mvc.common.enums.ErrorConstants;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final String errorCode;

    public BusinessException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorConstants errorConstants) {
        super(errorConstants.getErrorMessage());
        this.errorCode = errorConstants.getErrorCode();
    }
}
