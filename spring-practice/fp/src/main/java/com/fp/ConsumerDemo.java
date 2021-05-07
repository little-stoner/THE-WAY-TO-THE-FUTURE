package com.fp;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerDemo {

    private static final Stream<String> cities = Stream.of("Sydney", "Dhaka", "New York", "London");

    // implementation interface
    /*************************************************************/
    private static class C0 implements Consumer<String> {
        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    }
    private static class C00 implements Consumer<String> {
        @Override
        public void accept(String s) {
            System.out.println("*******************");
        }
    }

    public static void consume00() {
        C0 c0 = new C0();
        cities.forEach(c0.andThen(new C00()));
    }
    /************************************************************/

    // lambda expression
    /************************************************************/
    public static void consume0() {
        Consumer<String> printConsumer = t -> System.out.println(t);
        cities.forEach(printConsumer);
    }

    public static void consume1() {
        Consumer<String> printConsumer = t -> System.out.println(t);
        printConsumer = printConsumer.andThen(t -> System.out.println("=========="));
        cities.forEach(printConsumer);
    }
    /************************************************************/

    public static void main(String[] args) {
        consume00();
    }


}
