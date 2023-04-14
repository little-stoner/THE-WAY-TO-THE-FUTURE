package com.x.ioc.xaware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class XBeanNameAware implements BeanNameAware {

    @Override
    public void setBeanName(String name) {
        System.out.println(">>>>>>>>>>>>> beanName: " + name);
    }

    @Configuration
    public static class Config {
        @Bean(name = "customBean")
        public XBeanNameAware getXBean() {
            return new XBeanNameAware();
        }
        @Bean
        public XBeanFactoryAware getMyBeanFactory() {
            return new XBeanFactoryAware();
        }
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        XBeanFactoryAware factoryAware = context.getBean(XBeanFactoryAware.class);
        factoryAware.getBeanName();

    }

}
