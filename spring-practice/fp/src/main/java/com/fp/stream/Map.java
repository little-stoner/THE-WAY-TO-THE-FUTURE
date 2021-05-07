package com.fp.stream;


import java.util.stream.Stream;

/**
 *  produce a new stream after applying a function to each
 *  element of the original stream
 */

public class Map {

    public static void main(String[] args) {
        Stream.of(1, 2, 3).map(i -> "i => " + String.valueOf(i)).forEach(System.out::println);
    }



}
