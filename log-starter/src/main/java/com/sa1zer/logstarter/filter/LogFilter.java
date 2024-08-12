package com.sa1zer.logstarter.filter;

import com.sa1zer.logstarter.utils.HttpLogger;
import com.sa1zer.logstarter.utils.HttpUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        if(request instanceof HttpServletRequest httpRequest &&
            response instanceof HttpServletResponse httpResponse) {

            long start = System.currentTimeMillis();
            filterChain.doFilter(request, response);
            long end = System.currentTimeMillis();

            log.info(HttpLogger.httpLoggerBuild(httpRequest.getRequestURI(),
                    httpRequest.getMethod(), HttpUtils.getRequestHeadersAsString(httpRequest),
                    HttpUtils.getResponseHeadersAsString(httpResponse),
                    httpResponse.getStatus(), start, end));
        } else filterChain.doFilter(request, response);
    }
}
