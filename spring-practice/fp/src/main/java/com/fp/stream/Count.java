package com.fp.stream;

import java.util.stream.Stream;

public class Count {

    public static void main(String[] args) {
        System.out.println(
                Stream.of(1, 2, 3).filter(i -> i > 2).count()
        );
    }

}
