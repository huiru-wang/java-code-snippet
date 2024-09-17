package com.xiaohan.demo.spring.mvc.model.param;

import lombok.Data;

import java.util.List;

@Data
public class OrderQueryParam {

    private List<String> orderIdList;
}
