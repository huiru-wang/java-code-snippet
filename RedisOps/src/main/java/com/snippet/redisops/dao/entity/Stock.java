package com.snippet.redisops.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * create by whr on 2023-05-31
 */
@Getter
@Setter
@TableName("t_stock")
public class Stock {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @TableField(value = "stock")
    private Long stock;
}
