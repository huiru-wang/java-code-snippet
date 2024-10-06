package com.xiaohan.demo.spring.mvc.interceptor;

import com.xiaohan.demo.spring.mvc.common.constants.GlobalConstants;
import com.xiaohan.demo.spring.mvc.util.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 增加服务间的 trace id 追踪全链路日志
 */
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) {
        log.info("[Interceptor]: preHandler");
        String traceId = request.getHeader(GlobalConstants.X_TRACE_ID);
        if (StringUtils.isEmpty(traceId)) {
            MDC.put(GlobalConstants.TRACE_ID, IdUtils.UUID());
        } else {
            MDC.put(GlobalConstants.TRACE_ID, traceId);
        }
        return true;
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        String traceId = MDC.get(GlobalConstants.X_TRACE_ID);
        log.info("[Interceptor]: postHandler, TraceId: {}", traceId);
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("[Interceptor]: afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
