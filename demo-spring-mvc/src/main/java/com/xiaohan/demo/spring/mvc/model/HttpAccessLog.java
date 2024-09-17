package com.xiaohan.demo.spring.mvc.model;

import com.alibaba.fastjson.JSON;
import com.xiaohan.demo.spring.mvc.common.constants.GlobalConstants;
import lombok.Builder;
import lombok.Data;
import org.slf4j.MDC;

/**
 * 接口日志
 */
@Data
@Builder
public class HttpAccessLog {

    private String traceId;

    private String ip;

    private String interfaceName;

    private String path;

    private String httpMethod;

    private long timeCost;

    private Object request;

    private Object response;

    @Override
    public String toString() {
        StringBuilder interfaceLog = new StringBuilder();
        interfaceLog.append(GlobalConstants.Separator.VERTICAL_LINE)
                .append(GlobalConstants.TRACE_ID)
                .append(":")
                .append(MDC.get(GlobalConstants.TRACE_ID))
                .append(GlobalConstants.Separator.VERTICAL_LINE)
                .append(this.ip)
                .append(GlobalConstants.Separator.VERTICAL_LINE)
                .append(this.httpMethod)
                .append(GlobalConstants.Separator.VERTICAL_LINE)
                .append(this.path)
                .append(GlobalConstants.Separator.VERTICAL_LINE)
                .append(this.interfaceName)
                .append(GlobalConstants.Separator.VERTICAL_LINE)
                .append(this.timeCost)
                .append(GlobalConstants.Separator.VERTICAL_LINE)
                .append(JSON.toJSONString(this.request))
                .append(GlobalConstants.Separator.VERTICAL_LINE)
                .append(JSON.toJSONString(this.response));
        return interfaceLog.toString();
    }
}
