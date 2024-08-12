package com.sa1zer.logstarter.config;

import com.sa1zer.logstarter.aspect.HttpOapLogger;
import com.sa1zer.logstarter.filter.LogFilter;
import com.sa1zer.logstarter.interceptor.LogInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@Slf4j
@AutoConfiguration
@EnableConfigurationProperties(LogProperties.class)
@ConditionalOnClass(LogProperties.class)
public class LogAutoConfiguration {

    @Bean
    @ConditionalOnExpression("${http-logger.using-oap:false}")
    public HttpOapLogger httpOapLogger() {
        log.info("Using Http-oap logger...");
        return new HttpOapLogger();
    }

    @Bean
    @ConditionalOnExpression("${http-logger.using-filter:true}")
    public LogFilter logFilter() {
        log.info("Using Http-log-filter logger...");
        return new LogFilter();
    }

    @Bean
    @ConditionalOnExpression("${http-logger.using-interceptor:false}")
    public LogInterceptor logInterceptor() {
        log.info("Using Http-log-interceptor logger...");
        return new LogInterceptor();
    }

}
