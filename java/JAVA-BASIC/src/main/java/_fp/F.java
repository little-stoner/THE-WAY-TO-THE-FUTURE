package _fp;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class F {

    static class C {
        static void p(String arg) {
            System.out.println(">>>>>" + arg);
        }
    }

    static class S {
        static int f() {
            return 0;
        }
    }

    static class P {
        static boolean check(Integer i) {
            return i > 10;
        }
    }

    public static void consume(Consumer<String> c) {
        c.accept("KKK");
    }
    public static Integer supply(Supplier<Integer> s) {
        return s.get();
    }
    public static boolean predict(Predicate<Integer> p, Integer i) {
        return p.test(i);
    }

    public static void main(String[] args) {
        consume(C::p);
        System.out.println(supply(S::f));
        System.out.println(predict(P::check, 9));
        System.out.println(predict(P::check, 11));
    }

}
