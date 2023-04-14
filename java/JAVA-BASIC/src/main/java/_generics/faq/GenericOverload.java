package _generics.faq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericOverload<T> {

    static void overloadedMethod(Object o) {
        System.out.println("overloadedMethod(Object) called");
    }

    static void overloadedMethod(String s) {
        System.out.println("overloadedMethod(String) called");
    }

    static void overloadedMethod(Integer i) {
        System.out.println("overloadedMethod(Integer) called");
    }

    static <T> void genericMethod(T t) {
        overloadedMethod(t); // which method is called?
    }


    //===========================================================================

    private void overloadedMethod0(Collection<?> o) {
        System.out.println("overloadedMethod(Collection<?>)");
    }
    private void overloadedMethod0(List<Number> s) {
        System.out.println("overloadedMethod(List<Number>)");
    }
    private void overloadedMethod0(ArrayList<Integer> i) {
        System.out.println("overloadedMethod(ArrayList<Integer>)");
    }
    private void method0(List<T> t) {
        overloadedMethod0(t); // which method is called?
    }

    public static void main(String[] args) {
        genericMethod("abc");
        new GenericOverload<Integer>().method0(new ArrayList<Integer>());
    }
}
