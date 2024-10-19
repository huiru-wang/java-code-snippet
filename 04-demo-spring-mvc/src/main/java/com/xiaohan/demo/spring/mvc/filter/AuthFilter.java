package com.xiaohan.demo.spring.mvc.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "authFilter", urlPatterns = "/api/user/param/*")
public class AuthFilter implements Filter, Ordered {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("[Custom AuthFilter]: doFilter before");

        filterChain.doFilter(servletRequest, servletResponse);

        log.info("[Custom AuthFilter]: doFilter after");
    }

    @Override
    public int getOrder() {
        return 5;
    }
}
