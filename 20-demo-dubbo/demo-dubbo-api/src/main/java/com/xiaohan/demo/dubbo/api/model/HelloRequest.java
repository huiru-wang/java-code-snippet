package com.xiaohan.demo.dubbo.api.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class HelloRequest implements Serializable {

    private String source;

    private String message;
}
