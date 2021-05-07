package com.fp.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Distinct {

    public static void main(String[] args) {
        System.out.println(
                Stream.of(2, 2, 4, 4).distinct().collect(Collectors.toList())
        );
    }

}
