package com.x.ioc.xaware;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class XBeanFactoryAware implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void getBeanName() {
        XBeanNameAware xBeanNameAware = beanFactory.getBean(XBeanNameAware.class);
        System.out.println(">>>>>>>>>>>" + beanFactory.isSingleton("customBean"));
    }

}
