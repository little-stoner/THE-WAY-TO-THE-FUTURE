package _proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CGLIB {

    public static void main(String[] args) {
        List<String> ary = new ArrayList<>();
        ary.add("Hello");
        ary.add("Proxy");
        ary.add("World!!");

        log("create a interface proxy");
        List<String> proxyAry = (List<String>) Enhancer.create(List.class, new MyInvocationHandler(ary));
        for (int i = 0; i < 4; i++) { log(proxyAry.get(i)); }

        log("create a class proxy");
        proxyAry = (List<String>)Enhancer.create(ArrayList.class, new MyInvocationHandler(ary));
        for (int i = 0; i < 4; i++) { log(proxyAry.get(i)); }
    }

    private static void log(Object msg) {
        System.out.println(msg);
    }

    static class MyInvocationHandler implements MethodInterceptor {
        private List<String> ary;
        public MyInvocationHandler(List<String> ary) {
            this.ary = ary;
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            if (isFourthGet(method, args)) {
                return "Bow!!";
            }
            return proxy.invoke(ary, args);
        }

        private boolean isFourthGet(Method method, Object[] args) {
            return "get".equals(method.getName()) && ((Integer)args[0]) == 3;
        }
    }

}
