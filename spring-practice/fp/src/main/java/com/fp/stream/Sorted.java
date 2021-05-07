package com.fp.stream;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorted {

    public static void main(String[] args) {
        System.out.println(
                Stream.of(1, 2, 3, 4)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
        );
    }

}
