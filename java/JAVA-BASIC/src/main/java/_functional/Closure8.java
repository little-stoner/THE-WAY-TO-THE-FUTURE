package _functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Closure8 {
    Supplier<List<Integer>> makeFun() {
        final List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return () -> ai;
    }

    public static void main(String[] args) {
        Closure8 c = new Closure8();
        List<Integer>
                l1 = c.makeFun().get(),
                l2 = c.makeFun().get();
        System.out.println(l1);
        System.out.println(l2);
        l1.add(23);
        l2.add(42);
        System.out.println(l1);
        System.out.println(l2);
    }
}
