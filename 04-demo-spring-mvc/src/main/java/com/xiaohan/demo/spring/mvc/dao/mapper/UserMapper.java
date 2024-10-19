package com.xiaohan.demo.spring.mvc.dao.mapper;

import com.xiaohan.demo.spring.mvc.dao.entity.UserEntity;
import com.xiaohan.demo.spring.mvc.model.param.QueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mybatis-Plus
 */
@Mapper
public interface UserMapper extends BatchBaseMapper<UserEntity> {

    List<UserEntity> selectByCondition(@Param("queryParam") QueryParam queryParam);
}
