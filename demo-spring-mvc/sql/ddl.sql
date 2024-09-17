CREATE TABLE `demo_spring_mvc`.`t_user`
(
    `id`         varchar(255) NOT NULL,
    `user_id`    varchar(128) NOT NULL,
    `username`   varchar(32)  NOT NULL,
    `password`   varchar(64)  NOT NULL,
    `phone`      varchar(32)  NOT NULL,
    `status`     tinyint NOT NULL,
    `updateTime` datetime     NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    `createTime` datetime     NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `demo_spring_mvc`.`t_order`
(
    `id`         bigint      NOT NULL COMMENT 'id',
    `order_id`   varchar(255) NOT NULL COMMENT '订单id',
    `user_id`    varchar(128) NOT NULL COMMENT '用户Id',
    `amount`     varchar(32)      NOT NULL COMMENT '订单总价',
    `currency_code` VARCHAR(32) NOT NULL COMMENT '币种',
    `type`       varchar(32)      NOT NULL COMMENT '订单类型',
    `channel`    varchar(32) NOT NULL COMMENT '交易渠道',
    `status`     tinyint     NOT NULL COMMENT '交易状态：0-成功；-1：失败；1：已关闭；2：处理中',
    `remarks`    varchar(255) DEFAULT NULL COMMENT '订单备注',
    `ext`        varchar(255) DEFAULT NULL COMMENT '扩展字段',
    `create_time` datetime     NOT NULL  ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime     NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;