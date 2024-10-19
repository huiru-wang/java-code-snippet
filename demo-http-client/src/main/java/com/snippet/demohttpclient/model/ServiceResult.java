package com.snippet.demohttpclient.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceResult<T> implements Serializable {

    private boolean success;

    private T data;

    private String errorCode;

    private String errorMsg;

    private ServiceResult() {}

    public static <T> ServiceResult<T> success(T data) {
        ServiceResult<T> serviceResult = new ServiceResult<>();
        serviceResult.setSuccess(true);
        serviceResult.setData(data);
        return serviceResult;
    }

    public static <T> ServiceResult<T> fail(String errorCode, String errorMsg) {
        ServiceResult<T> serviceResult = new ServiceResult<>();
        serviceResult.setSuccess(false);
        serviceResult.setErrorCode(errorCode);
        serviceResult.setErrorMsg(errorMsg);
        return serviceResult;
    }
}
