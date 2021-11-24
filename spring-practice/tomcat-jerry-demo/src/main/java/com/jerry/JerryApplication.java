package com.jerry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class JerryApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JerryApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(JerryApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String k() {
        return "KKK";
    }

    @RequestMapping(value = "/a")
    public String hello() {
        return "<center>Hello tom & jerry<center>";
    }

}
