package _8.func;

import java.util.function.DoubleFunction;
import java.util.function.Function;

public class Compose {

    public static void main(String[] args) {
        Function<Integer, Integer> f0 = x -> x + 1;
        Function<Integer, Integer> f1 = x -> x * 2;
        Function<Integer, Integer> f2 = f1.andThen(f0);
        Function<Integer, Integer> f3 = f1.compose(f0);
        System.out.println(f2.apply(1));

        System.out.println(f3.apply(1));

    }
    public static double integrate(DoubleFunction<Double> f, double a, double b) {
        return (f.apply(a) + f.apply(b)) * (b - a) / 2.0;
    }
}
