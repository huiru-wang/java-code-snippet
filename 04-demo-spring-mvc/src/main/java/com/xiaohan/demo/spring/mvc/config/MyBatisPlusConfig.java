package com.xiaohan.demo.spring.mvc.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


/**
 * <pre>
 * 1、MybatisSqlSessionFactoryBean
 * 2、GlobalConfig
 * 3、分页功能
 * 4、自动填充: 如果是自定义SQL，不要使用@Param注解，将导致自动填充失效
 * 5、注入批量插入功能 需要扩展BaseMapper，实现insertBatchSomeColumn
 * </pre>
 */
@Slf4j
@Configuration
@MapperScan("com.xiaohan.demo.spring.mvc.dao.mapper")
public class MyBatisPlusConfig {

    @Bean
    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean(@Autowired HikariDataSource hikariDataSource, @Autowired GlobalConfig globalConfig) throws IOException {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(hikariDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        sqlSessionFactoryBean.setGlobalConfig(globalConfig);
        sqlSessionFactoryBean.setPlugins(paginationInterceptor()); // 增加分页功能
        return sqlSessionFactoryBean;
    }

    @Bean
    public GlobalConfig globalConfig() {
        // db config
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        dbConfig.setLogicDeleteValue("1");
        dbConfig.setLogicNotDeleteValue("0");
        dbConfig.setTablePrefix("t_");

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setBanner(false);
        globalConfig.setDbConfig(dbConfig);
        globalConfig.setMetaObjectHandler(new CustomMetaObjectHandler()); // 自动填充 时间
        globalConfig.setSqlInjector(new EasySqlInjector()); // 添加自定义SQL的注入器
        return globalConfig;
    }

    public class EasySqlInjector extends DefaultSqlInjector {

        /**
         * globalConfig.setSqlInjector(easySqlInjector); // 需要添加自定义SQL的注入器
         */
        @Override
        public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
            List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
            methodList.add(new InsertBatchSomeColumn(i -> i.getFieldFill() != FieldFill.UPDATE)); // 添加InsertBatchSomeColumn
            return methodList;
        }
    }

    /**
     * 自动填充配置
     * 需要在对应字段添加：@TableField(fill = FieldFill.INSERT_UPDATE)
     */
    public class CustomMetaObjectHandler implements MetaObjectHandler {

        @Override
        public void insertFill(MetaObject metaObject) {
            this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
            this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }

        @Override
        public void updateFill(MetaObject metaObject) {
            this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }
    }

    /**
     * 分页插件
     */
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
