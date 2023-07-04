package com.snippet.springtransaction.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * 必须Bean：
 * 1、DataSource
 * <p>
 * 2、TransactionManager
 * <p>
 * create by whr on 2023-05-26
 */
@Aspect
@Configurable
public class GlobalTxConfig {

    private final static int TX_TIMEOUT = 5000;

    private final static String POINTCUT_EXP = "execution(* com.snippet.springtransaction.service..*.*(..))";

    @Autowired
    @Qualifier("transactionManager")
    private TransactionManager transactionManager;

    @Bean
    public TransactionInterceptor transactionInterceptor() {
        NameMatchTransactionAttributeSource attributeSource = new NameMatchTransactionAttributeSource();
        // 通过对source添加多个Attribute，增加配置
        // 1. 只读配置
        RuleBasedTransactionAttribute readOnlyAttribute = new RuleBasedTransactionAttribute();
        readOnlyAttribute.setReadOnly(true);
        readOnlyAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);  // 使用当前事务,无则创建新事务
        Map<String, TransactionAttribute> attributeMap = new HashMap<>();
        attributeMap.put("select*", readOnlyAttribute);  // 只读事务切点
        attributeMap.put("get*", readOnlyAttribute);
        attributeMap.put("list*", readOnlyAttribute);

        // 2. 配置增删改事务
        RuleBasedTransactionAttribute attribute = new RuleBasedTransactionAttribute();
        attribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED); // default
        attribute.setTimeout(TX_TIMEOUT);
        attributeMap.put("save*", attribute);
        attributeMap.put("update*", attribute);
        // ...
        attributeSource.setNameMap(attributeMap);
        return new TransactionInterceptor(transactionManager, attributeSource);
    }

    @Bean
    public Advisor txAdviceAdvisor(@Autowired TransactionInterceptor transactionInterceptor) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(POINTCUT_EXP);
        return new DefaultPointcutAdvisor(pointcut, transactionInterceptor);
    }
}

