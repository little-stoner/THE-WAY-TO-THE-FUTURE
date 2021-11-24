package com.stone;

import net.sf.cglib.beans.BeanGenerator;

import java.lang.reflect.Method;

public class B {

    public static void main(String[] args) throws Exception {

        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("name", String.class);

        Object mb = beanGenerator.create();

        Method setter = mb.getClass().getMethod("setName", String.class);
        setter.invoke(mb, "some string value set by a cglib");

        Method getter = mb.getClass().getMethod("getName");
        System.out.println(getter.invoke(mb));

    }

}
