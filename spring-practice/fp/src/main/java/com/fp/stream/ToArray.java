package com.fp.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ToArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Stream.of(1, 2, 3).toArray()));
    }

}
