package com.fp.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitioningBy {

    public static void main(String[] args) {

        System.out.println(

                Stream.of(1, 2, 3, 4).collect(Collectors.partitioningBy(i -> i % 2 == 0))

        );

    }

}
