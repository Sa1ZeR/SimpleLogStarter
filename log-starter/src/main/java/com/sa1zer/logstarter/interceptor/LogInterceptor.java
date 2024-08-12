package com.sa1zer.logstarter.interceptor;

import com.sa1zer.logstarter.utils.HttpLogger;
import com.sa1zer.logstarter.utils.HttpUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    private long start;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        start = System.currentTimeMillis();
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long end = System.currentTimeMillis();

        log.info(HttpLogger.httpLoggerBuild(request.getRequestURI(),
                request.getMethod(), HttpUtils.getRequestHeadersAsString(request),
                HttpUtils.getResponseHeadersAsString(response),
                response.getStatus(), start, end));
    }
}
