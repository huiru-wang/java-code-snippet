package com.snippet.springtransaction.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snippet.springtransaction.dao.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * create by whr on 2023-05-26
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
