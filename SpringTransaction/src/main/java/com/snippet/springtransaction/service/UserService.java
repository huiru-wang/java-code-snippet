package com.snippet.springtransaction.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.snippet.springtransaction.dao.entity.User;
import com.snippet.springtransaction.dao.mapper.UserMapper;
import com.snippet.springtransaction.utils.Tools;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * create by whr on 2023-05-26
 */
@Slf4j
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Autowired
    private TransactionTemplate transactionTemplate;

    public void txTemplate() {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(@NotNull TransactionStatus status) {
                User user = Tools.createUser();
                try {
                    baseMapper.insert(user);
                    int i = 1 / 0;
                } catch (Exception e) {
                    status.setRollbackOnly();
                    log.error("roll back: {}", user.getId());
                }
            }
        });
    }

    @Autowired
    private PlatformTransactionManager transactionManager;

    public void txProgram() {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        transactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT); // isolation
        transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED); // default
        TransactionStatus transaction = transactionManager.getTransaction(transactionDefinition);
        try {
            User user = Tools.createUser();
            baseMapper.insert(user);
            log.info("user:{}", user.getId());
            int i = 1 / 0;
            transactionManager.commit(transaction);
        } catch (Exception e) {
            transactionManager.rollback(transaction);
            log.error("roll back");
        }
    }

    @Autowired
    OrderService orderService;

    // 共用事务，任何方法抛出异常，被Transaction感知，则全部回滚
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void updateUserAndOrder1() {
        User user = Tools.createUser();
        log.info("create user: {}", user.getId());
        baseMapper.insert(user);
        orderService.createOrder1(user);
    }

    // 创建新的事务, 子事务的异常不会影响父事务
    @Transactional(rollbackFor = Exception.class)
    public void updateUserAndOrder2() {
        User user = Tools.createUser();
        log.info("create user: {}", user.getId());
        baseMapper.insert(user);
        orderService.createOrder2(user);
        int i = 1 / 0;
    }

    // NESTED放在父事务上，子事务回滚 不影响父事务
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public void updateUserAndOrder3() {
        User user = Tools.createUser();
        log.info("create user: {}", user.getId());
        baseMapper.insert(user);
        orderService.createOrder3(user);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void updateUserAndOrder4() {
        User user = Tools.createUser();
        log.info("create user: {}", user.getId());
        baseMapper.insert(user);
        orderService.createOrder4(user);
    }

    // @Transactional(rollbackFor = Exception.class)
    public void updateUserAndOrder5() {
        User user = Tools.createUser();
        log.info("create user: {}", user.getId());
        baseMapper.insert(user);
        orderService.createOrder5(user);
        int i = 1 / 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateUserAndOrder6() {
        User user = Tools.createUser();
        log.info("create user: {}", user.getId());
        baseMapper.insert(user);
        orderService.createOrder6(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateUserAndOrder7() {
        User user = Tools.createUser();
        log.info("create user: {}", user.getId());
        baseMapper.insert(user);
        orderService.createOrder7(user);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true, timeout = 20)
    public void updateUserAndOrder8() {
        long userId = 1112122L;
        baseMapper.selectById(userId);
        orderService.selectOrderByUserId(userId);
    }
}
