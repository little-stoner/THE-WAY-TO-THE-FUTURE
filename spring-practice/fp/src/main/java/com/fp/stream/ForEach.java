package com.fp.stream;

import java.util.stream.Stream;

/**
 *  for each accept a consumer function
 */
public class ForEach {

    public static void main(String[] args) {

        Stream.of(1, 2, 3).forEach(System.out::println);

    }

}
