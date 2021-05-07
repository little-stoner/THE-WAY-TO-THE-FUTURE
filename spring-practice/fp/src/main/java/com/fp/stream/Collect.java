package com.fp.stream;


import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  get stuff out of the stream once we are done with all the processing
 *
 */

public class Collect {

    public static void main(String[] args) {
        System.out.println(Stream.of(1, 2, 3).collect(Collectors.toMap(i -> i, Integer::intValue)));
        System.out.println(Stream.of(1, 2, 3).collect(Collectors.toMap(i -> i + ">>|<<", Integer::intValue)));
    }

}
