package com.fp.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class Min {

    public static void main(String[] args) {
        System.out.println(
                Stream.of(1, 2, 3).min((Integer::compareTo)).orElseThrow(() -> new RuntimeException(""))
        );
        System.out.println(
                Stream.of(1, 2, 3).max((Integer::compareTo)).orElseThrow(() -> new RuntimeException(""))
        );
    }

}
