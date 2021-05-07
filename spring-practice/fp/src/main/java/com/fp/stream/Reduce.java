package com.fp.stream;

import java.util.stream.Stream;

public class Reduce {

    public static void main(String[] args) {
        System.out.println(
                Stream.of(1, 2, 3).reduce(0, Integer::sum)
        );
        System.out.println(
                Stream.of(1, 2, 3).reduce(10, Integer::sum)
        );
    }

}
