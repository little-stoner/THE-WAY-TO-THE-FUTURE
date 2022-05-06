package _proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDKDynamic {

    public static void main(String[] args) {
        ClassLoader loader = JDKDynamic.class.getClassLoader();
        Map proxyAry = (Map) Proxy.newProxyInstance(
                loader, new Class<?>[]{Map.class}, new MyInvocationHandler());
        proxyAry.put("foo", "bar");
        System.out.println(proxyAry.get("foo"));
    }
    private static void log(Object msg) {
        System.out.println(msg);
    }

    static class MyInvocationHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(" ===> method: " + method);
            System.out.println(" ===> args: " + args);
            System.out.println(">>>>>>>>>>>> before <<<<<<<<<<");
            // return method.invoke(ary, args);
            System.out.println(proxy.getClass());
            return 12;
        }
    }

}
