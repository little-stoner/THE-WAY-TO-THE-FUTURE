package com.fp.stream;

import java.util.stream.Stream;

public class FindFirst {

    public static void main(String[] args) {
        System.out.println(Stream.of(1, 2, 3).filter(i -> i > 2).findFirst().orElse(null));
        System.out.println(Stream.of(1, 2, 3).filter(i -> i > 3).findFirst().orElse(null));
    }

}
