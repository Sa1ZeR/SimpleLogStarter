package com.sa1zer.logstarter.config;

import com.sa1zer.logstarter.aspect.HttpOapLogger;
import com.sa1zer.logstarter.filter.LogFilter;
import com.sa1zer.logstarter.interceptor.LogInterceptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = "spring.profiles.active=test-interceptor")
class LogAutoConfigurationTest {


    @Autowired(required = false)
    private HttpOapLogger httpOapLogger;

    @Autowired(required = false)
    private LogFilter logFilter;

    @Autowired(required = false)
    private LogInterceptor logInterceptor;

    @Value("${http-logger.using-oap}")
    private boolean oapLoggerEnabled;
    @Value("${http-logger.using-filter}")
    private boolean logFilterEnabled;
    @Value("${http-logger.using-interceptor}")
    private boolean logInterceptorEnabled;

    @Test
    void httpOapLogger() {
        if(oapLoggerEnabled) assertThat(httpOapLogger).isNotNull();
        else assertThat(httpOapLogger).isNull();
    }

    @Test
    void logFilter() {
        if(logFilterEnabled) assertThat(logFilter).isNotNull();
        else assertThat(logFilter).isNull();
    }

    @Test
    void logInterceptor() {
        if(logInterceptorEnabled) assertThat(logInterceptor).isNotNull();
        else assertThat(logInterceptor).isNull();
    }
}