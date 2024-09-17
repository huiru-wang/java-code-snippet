package com.xiaohan.demo.spring.mvc.model.param;

import lombok.Data;

import java.util.List;

@Data
public class QueryParam {

    private String userName;

    private List<String> userIdList;

    private List<String> phoneNoList;
}
