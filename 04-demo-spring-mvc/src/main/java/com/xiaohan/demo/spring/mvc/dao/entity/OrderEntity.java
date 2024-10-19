package com.xiaohan.demo.spring.mvc.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@TableName("t_order")
public class OrderEntity {

    private Long id;

    private String orderId;

    private String userId;

    private Long amount;

    private String currencyCode;

    private String channel;

    private Integer status;

    private String remarks;

    private String ext;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
