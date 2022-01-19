package _efectivejava.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class _15_Overloading {

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
        overloadedMethod(t);
    }

    public static void main(String[] args) {
        genericMethod("abc");
    }

    public static final class GenericClass<T> {
        private void overloadedMethod(Collection<?> o) {
            System.out.println("overloadedMethod(Collection<?>)");
        }
        private void overloadedMethod(List<Number> s) {
            System.out.println("overloadedMethod(List<Number>)");
        }
        private void overloadedMethod(ArrayList<Integer> i) {
            System.out.println("overloadedMethod(ArrayList<Integer>)");
        }
        private void method(List<T> t) {
            overloadedMethod(t); // which method is called?
        }
        public static void main (String[] args){
            GenericClass<Integer> test = new GenericClass<Integer>();
            test.method(new ArrayList<Integer>());
        }
    }

}
