package com.jdk;

import com.jdk.proxy.MethodExecutorLogger;
import com.jdk.proxy.Service;
import com.jdk.service.BookService;
import com.jdk.service.BookServiceImpl;

import java.lang.reflect.Proxy;

public class App {

    public static void main(String[] args) {
        BookService bookService = getProxyOf(new BookServiceImpl(), BookService.class);
        bookService.getBookById(123L);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Service> T getProxyOf(T instanceImpl, Class<? extends Service> interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[] {interfaceClass},
                new MethodExecutorLogger(instanceImpl));
    }

}
