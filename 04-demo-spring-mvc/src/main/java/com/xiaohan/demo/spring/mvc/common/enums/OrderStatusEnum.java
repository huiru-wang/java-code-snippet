package com.xiaohan.demo.spring.mvc.common.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {

    INIT(0, "已创建"),

    PENDING_PAYMENT(1, "待付款"),

    PENDING_SHIPMENT(2, "待发货"),

    PENDING_RECEIPT(3, "待收货"),

    FINISHED(4, "已完成");

    private final int code;

    private final String desc;

    OrderStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
