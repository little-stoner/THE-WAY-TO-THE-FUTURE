package com.jdk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MethodExecutorLogger implements InvocationHandler {

    private Service service;
    public MethodExecutorLogger(Service service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            System.out.println(" Before =============> ");
            System.out.println(String.format("Executing %s method", method.getName()));
            return method.invoke(service, args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            System.out.println(" After In Finally =========>");
        }
    }
}
