package com.fp;

import java.util.function.Predicate;

public class PredicateDemo {


    public static Predicate<Integer> predicate = a -> a.equals(1);

    public static void main(String[] args) {
        System.out.println(predicate.test(2));
    }

}
