package _x.lib.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static java.lang.reflect.Proxy.newProxyInstance;

public class J0 {

    interface Foo {
        Object bar(Object obj);
    }
    static class FooImpl implements Foo {
        private String name;
        @Override
        public Object bar(Object obj) {
            return obj;
        }

        public String getName() {
            return name;
        }
    }

    static class DebugProxy implements InvocationHandler {
        private Object obj;

        public static Object newInstance(Object obj) {
            return Proxy.newProxyInstance(
                    obj.getClass().getClassLoader(),
                    obj.getClass().getInterfaces(),
                    new DebugProxy(obj));
        }

        private DebugProxy(Object obj) {
            this.obj = obj;
        }
        @Override
        public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
            Object result;
            try {
                System.out.println("before method " + m.getName());
                result = m.invoke(obj, args);
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            } catch (Exception e) {
                throw new RuntimeException("unexpected invocation exception: " +
                        e.getMessage());
            } finally {
                System.out.println("after method " + m.getName());
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Foo foo = (Foo) DebugProxy.newInstance(new FooImpl());
        foo.bar(null);
    }

}
