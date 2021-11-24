package com.stone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringAopDemoApplication {

    @Autowired
    private T t;

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(SpringAopDemoApplication.class, args);
        ((T)app.getBean("t")).list("KKK");
    }


}
