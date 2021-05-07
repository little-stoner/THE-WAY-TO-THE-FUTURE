package com.kickoff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KickoffApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(KickoffApplication.class, args);
        System.out.println(app);
    }

}
