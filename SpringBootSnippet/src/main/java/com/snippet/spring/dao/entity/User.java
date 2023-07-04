package com.snippet.spring.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


/**
 * <p>
 *
 * </p>
 *
 * @author will
 * @since 2023-01-28 07:41:01
 */
@Getter
@Setter
@TableName("t_user")
@ApiModel(value = "User对象", description = "")
public class User {

    @ApiModelProperty("userId")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("用户Id")
    @TableField(value = "username")
    private String username;

    @ApiModelProperty("password")
    @TableField("password")
    private String password;
    @ApiModelProperty("phone")
    @TableField("phone")
    private String phone;
    @ApiModelProperty("email")
    @TableField("email")
    private String email;
    @ApiModelProperty("create_at")
    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @ApiModelProperty("type")
    @TableField("type")
    private Integer type;
    @ApiModelProperty("status")
    @TableField("status")
    private Integer status;

}
