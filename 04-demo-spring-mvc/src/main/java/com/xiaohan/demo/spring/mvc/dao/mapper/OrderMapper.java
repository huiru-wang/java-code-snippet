package com.xiaohan.demo.spring.mvc.dao.mapper;

import com.xiaohan.demo.spring.mvc.dao.entity.OrderEntity;
import com.xiaohan.demo.spring.mvc.model.param.OrderQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mybatis
 */
@Mapper
public interface OrderMapper {

    int insert(@Param("order") OrderEntity order);

    int update(@Param("order") OrderEntity order);

    int insertOrUpdate(@Param("order") OrderEntity order);

    OrderEntity selectOneByOrderId(@Param("orderId") String orderNo);

    List<OrderEntity> selectListByCondition(@Param("queryParam")OrderQueryParam queryParam);
}
