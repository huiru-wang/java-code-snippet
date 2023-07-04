package com.snippet.redisops.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snippet.redisops.config.RedisTemplateConfig;
import com.snippet.redisops.dao.entity.Stock;
import com.snippet.redisops.dao.mapper.StockMapper;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * create by whr on 2023-05-31
 */
@Service
public class StockService extends ServiceImpl<StockMapper, Stock> implements IService<Stock> {

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private RedissonClient redissonClient;

    private static final String STOCK_LOCK = "stock_lock";
    private static final String STOCK = "stock_";

    public int stockByDB(Long stockId) {
        LambdaUpdateWrapper<Stock> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Stock::getId, stockId).setSql("stock = stock - 1");
        return this.update(updateWrapper) ? 1 : 0;
    }

    public int stockByMP(Long stockId) {
        return stockMapper.deduct(stockId);
    }


    public int stockByRedisson(Long stockId) {
        RLock lock = redissonClient.getLock(STOCK_LOCK);
        return 0;
    }

    @Autowired
    private ValueOperations<String, String> redisTemplate;

    public int stockByRedisTemplate(Long stockId) {
        return redisTemplate.decrement(STOCK + stockId).intValue();
    }
}
