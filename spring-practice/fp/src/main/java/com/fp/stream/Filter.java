package com.fp.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {

    public static void main(String[] args) {
        System.out.println(Stream.of(1, 2, 3, 4).filter(i -> i > 2).collect(Collectors.toList()));
    }

}
