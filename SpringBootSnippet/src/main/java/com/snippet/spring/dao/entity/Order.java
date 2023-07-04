package com.snippet.spring.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * create by whr on 2023-06-18
 */

@Getter
@Setter
@TableName("t_order")
@ApiModel(value = "Order对象", description = "")
public class Order {

    private Long id;
    private Long userId;
    private Integer status;
    private Integer type;
    private LocalDateTime createdAt;
}
