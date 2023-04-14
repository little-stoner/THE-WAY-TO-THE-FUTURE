package com.x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class EurekaXServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaXServerApplication.class, args);
    }


}
