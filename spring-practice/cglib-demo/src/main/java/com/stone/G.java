package com.stone;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;

public class G {

    public static void one() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(C.class);
        enhancer.setCallback((FixedValue) () -> "Hello KKK!");
        C proxy = (C) enhancer.create();
        String res = proxy.say(null);
        System.out.println(res);
    }

    public static void two() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(C.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            if (method.getDeclaringClass() != Object.class &&
                method.getReturnType() == String.class) {
                return "Hello KKK!";
            } else {
                return proxy.invokeSuper(obj, args);
            }
        });
        C proxy = (C) enhancer.create();
        System.out.println(proxy.say("III"));
        System.out.println(proxy.length("QQQ"));
    }

    public static void main(String[] args) {
        two();
    }

}
