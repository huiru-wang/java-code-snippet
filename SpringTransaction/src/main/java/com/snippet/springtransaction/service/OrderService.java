package com.snippet.springtransaction.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snippet.springtransaction.dao.entity.Order;
import com.snippet.springtransaction.dao.entity.User;
import com.snippet.springtransaction.dao.mapper.OrderMapper;
import com.snippet.springtransaction.utils.Tools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * create by whr on 2023-05-26
 */
@Slf4j
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    @Transactional(rollbackFor = Exception.class)
    public void createOrder1(User user) {
        Order order = Tools.createOrder(user);
        log.info("create order: {}", order.getId());
        baseMapper.insert(order);
        int i = 1 / 0;
    }

    // 创建新的事务，父事务回滚不会影响当前事务
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void createOrder2(User user) {
        Order order = Tools.createOrder(user);
        log.info("create order: {}", order.getId());
        baseMapper.insert(order);
        int i = 1 / 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public void createOrder3(User user) {
        Order order = Tools.createOrder(user);
        log.info("create order: {}", order.getId());
        baseMapper.insert(order);
        int i = 1 / 0;
    }

    public void createOrder4(User user) {
        Order order = Tools.createOrder(user);
        log.info("create order: {}", order.getId());
        baseMapper.insert(order);
    }

    // 父事务存在，就加入
    // 不存在，就不用事务
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    public void createOrder5(User user) {
        Order order = Tools.createOrder(user);
        log.info("create order: {}", order.getId());
        baseMapper.insert(order);
//        int i = 1 / 0;
    }


    // 无论怎么样都不使用事务，如果存在父事务，挂起父事务
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
    public void createOrder6(User user) {
        Order order = Tools.createOrder(user);
        log.info("create order: {}", order.getId());
        baseMapper.insert(order);
        int i = 1 / 0;  // 不影响本方法，因为不用事务，会影响父事务，异常被抛出
    }

    // 不使用事务，有则抛异常
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NEVER)
    public void createOrder7(User user) {

    }

    public void selectOrderByUserId(long userId) {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Order::getUserId, userId);
        List<Order> orders = baseMapper.selectList(queryWrapper);
    }
}
