package com.xiaohan.demo.spring.mvc.filter;

import lombok.extern.slf4j.Slf4j;

import org.springframework.core.Ordered;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * filter集成：
 * 1. 增加@Component注解(urlPattern是不生效)，不要这么使用
 * 2. @ServletComponentScan启动项增加此注解，不需要单独注入bean容器中
 */
@Slf4j
@WebFilter(filterName = "logFilter", urlPatterns = "/*")
public class LogFilter implements Filter, Ordered {

    /**
     * web容器初始化时执行
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("[Custom LogFilter]: init");
        Filter.super.init(filterConfig);
    }

    /**
     * 1. HttpServletRequest到达Servlet之前执行
     * 2. 执行FilterChain
     * 3. HttpServletResponse返回之前执行
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws ServletException, IOException {
        log.info("[Custom LogFilter]: doFilter before");

        filterChain.doFilter(servletRequest, servletResponse);

        log.info("[Custom LogFilter]: doFilter after");
    }

    /**
     * web容器销毁时执行
     */
    @Override
    public void destroy() {
        log.info("[Custom LogFilter]: destroy");
        Filter.super.destroy();
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
