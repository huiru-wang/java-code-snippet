package com.xiaohan.demo.dubbo.api.constants;

import lombok.Getter;

@Getter
public enum ErrorConstants {

    SYSTEM_ERROR("100001", "System Error"),

    INVALID_PARAM("100002", "Invalid Param");
    ;

    private final String errorCode;

    private final String errorMsg;

    ErrorConstants(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
