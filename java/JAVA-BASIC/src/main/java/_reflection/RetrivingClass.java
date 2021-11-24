package _reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class RetrivingClass {

    public String a;
    private String b;

    public enum Enum { A, B; }
    public @interface ANNO {}

    public void t(String a) {
        System.out.println("Kkkkkkkkk");
    }

    public static void main(String[] args) throws Exception {

        //
        // modifiers();
        memebers();
    }

    public static void clz() throws Exception {
        // object.getClass()
        System.out.println("a".getClass());
        System.out.println(Enum.A.getClass());
        System.out.println(ANNO.class);
        // .class syntax
        System.out.println(boolean.class);
        // Class.forName()
        System.out.println(Class.forName("_reflection.Benchmark"));
        // Type Field for Primitive Type Wrappers
        System.out.println(Integer.TYPE);
    }

    public static void modifiers() throws ClassNotFoundException {

        Class<?> c = Class.forName("java.util.concurrent.ConcurrentSkipListMap");
        System.out.format("Class: %n %s%n%n", c.getCanonicalName());
        System.out.format("Modifiers: %n %s%n%n", Modifier.toString(c.getModifiers()));

        TypeVariable<?>[] tv = c.getTypeParameters();
        System.out.println(Arrays.toString(tv));

        Type[] intfs = c.getInterfaces();
        System.out.println(Arrays.toString(intfs));
        Type[] intfs0 = c.getGenericInterfaces();
        System.out.println(Arrays.toString(intfs0));

        Class<?> ancestor = c.getSuperclass();
        System.out.println(ancestor);

        Annotation[] annotations = c.getAnnotations();
        System.out.println(Arrays.toString(annotations));

    }

    public static void memebers() throws Exception {

        Class<?> c = RetrivingClass.class;
        Field[] fields = c.getDeclaredFields();
        System.out.println(Arrays.toString(fields));
        fields = c.getFields();
        System.out.println(Arrays.toString(fields));

        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            if (m.getName().equals("t")) {
                Object r = c.getDeclaredConstructor().newInstance();
                m.invoke(r, "k");
            }
        }
    }

}
