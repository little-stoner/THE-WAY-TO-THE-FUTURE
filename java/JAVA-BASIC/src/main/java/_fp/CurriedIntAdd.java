package _fp;

import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class CurriedIntAdd {

    public static void main(String[] args) {
        IntFunction<IntUnaryOperator> c = a -> b -> a + b;
        IntUnaryOperator add4 = c.apply(4);
        System.out.println(add4.applyAsInt(5));
    }

}
