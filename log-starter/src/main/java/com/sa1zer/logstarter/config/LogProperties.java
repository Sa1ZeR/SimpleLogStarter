package com.sa1zer.logstarter.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "http-logger")
public class LogProperties {

    private Boolean usingFilter;
    private Boolean usingInterceptor;
    private Boolean usingOap;
}
