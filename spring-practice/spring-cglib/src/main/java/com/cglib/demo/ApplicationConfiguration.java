package com.cglib.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = true)
public class ApplicationConfiguration {

    @Bean
    public DefaultPostRepository postRepository() {
        return new DefaultPostRepository();
    }

    @Bean
    public DefaultPostService firstPostService() {
        return new DefaultPostService("first", postRepository(), logService());
    }

    @Bean
    public DefaultPostService secondPostService() {
        return new DefaultPostService("second", postRepository(), logService());
    }

    @Bean
    public static LogService logService() {
        return new LogService();
    }

}
