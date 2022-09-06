package _concurrent.completable;

import _onjava.Timer;

import java.util.stream.IntStream;

public class PizzaParallelSteps {
    static final int QUANTITY = 5;
    public static void main(String[] args) {
        Timer timer = new Timer();
        IntStream.range(0, QUANTITY)
                .mapToObj(Pizza::new)
                .parallel()
                .map(Pizza::roll)
                .map(Pizza::sauce)
                .map(Pizza::cheese)
                .map(Pizza::toppings)
                .map(Pizza::bake)
                .map(Pizza::slice)
                .map(Pizza::box)
                .forEach(za -> System.out.println(za));
        System.out.println(timer.duration());
    }
}
