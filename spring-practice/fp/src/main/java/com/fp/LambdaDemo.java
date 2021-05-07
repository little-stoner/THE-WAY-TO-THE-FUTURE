package com.fp;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaDemo {

    public static Function<String, String> fn = a -> a + " !!! ";
    public static Function<String, String> fn0 = new Function<String, String>() {
        @Override
        public String apply(String s) {
            return s + " !!! ";
        }
    };

    public static BiFunction<String, String, String> fnn = (a, b) -> a + " @-@ " + b;
    public static BiFunction<String, String, String> fnn0 = new BiFunction<String, String, String>() {
        @Override
        public String apply(String s1, String s2) {
            return s1 + " <==> " + s2;
        }
    };


    public static void main(String[] args) {

    }

}
