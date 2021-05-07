package com.fp.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Peek {

    public static void main(String[] args) {
        System.out.println(
                Stream.of(1, 2, 3).peek(i -> i.toString()).peek(System.out::println).collect(Collectors.toList())
        );
    }

}
