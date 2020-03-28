package com.learn.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author wu00y
 */
@Configuration
@PropertySource("classpath:undertow.properties")
@ConfigurationProperties(prefix="server.undertow")
@Data
public class UndertowConfig {
    private  Integer ioThreads;
    private  Integer workerThreads;
    private  Integer bufferSize;
    private  Boolean directBuffers;
}
