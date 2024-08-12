package com.sa1zer.logstarter.aspect;

import com.sa1zer.logstarter.utils.HttpUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Slf4j
public class HttpOapLogger {

    @Pointcut("within(@org.springframework.stereotype.Controller *) || within(@org.springframework.web.bind.annotation.RestController *)")
    public void logController() {}

    @Around("logController()")
    public Object doLogController(ProceedingJoinPoint joinPoint) throws Throwable {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes == null) {
            log.info("Server error");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Internal Server Error");
        }

        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();

        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long end = System.currentTimeMillis();

        log.info(com.sa1zer.logstarter.utils.HttpLogger.httpLoggerBuild(request.getRequestURI(),
                request.getMethod(), HttpUtils.getRequestHeadersAsString(request),
                HttpUtils.getResponseHeadersAsString(response),
                response.getStatus(), start, end));

        return proceed;
    }
}
