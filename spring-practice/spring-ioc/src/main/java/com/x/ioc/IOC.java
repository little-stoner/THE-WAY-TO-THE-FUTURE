package com.x.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

public class IOC {

    private static class Refresh implements ApplicationListener<ContextRefreshedEvent> {
        @Override
        public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("services.xml");
        context.addApplicationListener(new Refresh());

        X x = context.getBean("x", X.class);

        System.out.println(x);
        System.out.println(context.isSingleton("x"));


        // ((DefaultListableBeanFactory)context.getBeanFactory()).removeBeanDefinition("x");

        context.publishEvent(new ContextRefreshedEvent(context));

        // context.refresh();
        x.setName("kkkkkk");

        x = context.getBean("x", X.class);
        System.out.println(x);

        Thread.sleep(10000);

    }
}