package com.snippet.spring.dao.mapper;

import com.snippet.spring.dao.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BatchBaseMapper<Order> {

}
