package com.xiaohan.demo.spring.mvc.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.JdbcType;

import java.time.LocalDateTime;

@Getter
@Setter
@TableName("t_user")
public class UserEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "user_id", jdbcType = JdbcType.VARCHAR)
    private String userId;

    @TableField(value = "username", jdbcType = JdbcType.VARCHAR)
    private String username;

    @TableField(value = "password", jdbcType = JdbcType.VARCHAR)
    private String password;

    @TableField(value = "phone", jdbcType = JdbcType.VARCHAR)
    private String phone;

    @TableField(value = "status", jdbcType = JdbcType.TINYINT)
    private Integer status;

    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    @TableField(value = "updated_at", fill = FieldFill.UPDATE)
    private LocalDateTime updatedAt;
}
