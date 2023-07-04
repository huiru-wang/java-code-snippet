package com.snippet.redisops.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snippet.redisops.dao.entity.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * create by whr on 2023-05-31
 */
@Mapper
public interface StockMapper extends BaseMapper<Stock> {

    int deduct(@Param("stockId") Long stockId);
}
