package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class T {

    private String s;
    public T() { s = "SSS"; }
    public void m1() {
        System.out.println(" The s is : " + s);
    }
    public void m2(int n) {
        System.out.println(" The number is : " + n);
    }

    private void m3() {
        System.out.println(" ****** private method");
    }

    public static void main(String[] args) throws Exception {
        T t = new T();
        // get class
        System.out.println(t.getClass());
        System.out.println(" ====================== ");
        // get constructors
        System.out.println(Arrays.toString(t.getClass().getConstructors()));
        Constructor<? extends T> constructor = t.getClass().getDeclaredConstructor();
        T t1 = constructor.newInstance();
        System.out.println(" ------------- " + t1);
        System.out.println(" ====================== ");
        // get methods
        System.out.println(Arrays.toString(t.getClass().getMethods()));
        System.out.println(Arrays.toString(t.getClass().getDeclaredMethods()));
        System.out.println(t.getClass().getDeclaredMethod("m1"));
        System.out.println(t.getClass().getDeclaredMethod("m2", int.class));
        Method m3 = t.getClass().getDeclaredMethod("m3");
        m3.setAccessible(true);
        m3.invoke(t);
        System.out.println(" ====================== ");
        // get fields
        System.out.println(Arrays.toString(t.getClass().getFields()));
        System.out.println(Arrays.toString(t.getClass().getDeclaredFields()));
        Field field = t.getClass().getDeclaredField("s");
        field.setAccessible(true);
        field.set(t, "KKK");
        System.out.println(" ====================== ");
    }

}
