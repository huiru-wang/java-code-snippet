package com.xiaohan.demo.spring.mvc.dao.mapper;

import com.xiaohan.demo.spring.mvc.dao.entity.UserEntity;
import com.xiaohan.demo.spring.mvc.model.param.QueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author will
 * @since 2023-01-28 07:36:03
 */
@Mapper
public interface UserMapper extends BatchBaseMapper<UserEntity> {

    List<UserEntity> selectByCondition(@Param("queryParam") QueryParam queryParam);
}
