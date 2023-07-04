# Spring Transaction

SpringBoot不需要任何配置，直接使用@Transaction即可，如果要使用全局事务管理器，则需要自行配置

Spring中使用方式有以下几种

#### 前提：注入TransactionManager

```java
@Bean
@Qualifier("transactionManager")
public DataSourceTransactionManager txManager(@Autowired HikariDataSource hikariDataSource){
        return new DataSourceTransactionManager(hikariDataSource);
}
```

或使用XML：

```xml
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="hikariDataSource"/>
</bean>
```

#### 1、配置全局事务管理器；使用AOP指定切面；

匹配到的类、方法会自动按照配置的事务方式执行、回滚、传播；

具体配置可使用Java代码配置：GlobalTxConfig

也可xml配置：
```xml
<tx:advice id="txAdvice" transaction-manager="transactionManager">
    <tx:attributes>
        <tx:method name="add*"/>
        <tx:method name="insert*"/>
        <tx:method name="delete*"/>
        <tx:method name="update*"/>
        <tx:method name="select*" read-only="true"/>
    </tx:attributes>
</tx:advice>

<aop:config>
    <aop:pointcut id="txPointcut" expression="execution(* com.snippet.springtransaction.service.*(..))"/>
    <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointcut"/>
</aop:config>
```

#### 2、开启事务注解，自行在方法上添加@Transaction注解

在注解上，需要自行指定回滚方式、事务传播方式等；

只需要使用注解开启：

```java
@Configuration
@EnableTransactionManagement
```
使用时，自行添加@Transaction
```java
    @Transactional(rollbackFor = Exception.class)
    public void test() {
        // ...
    }
```

#### 3、编程式事务

自行指定隔离级别、传播方式、手动commit、rollback；

```java
public void test() {
    DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
    TransactionStatus transaction = transactionManager.getTransaction(transactionDefinition);
    try {
        // ...
        transactionManager.commit(transaction);
    } catch (Exception e) {
        transactionManager.rollback(transaction);
    }
}
```
