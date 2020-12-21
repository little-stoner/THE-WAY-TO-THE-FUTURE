package _onjava8._concurrent;

import java.util.*;
import java.util.stream.*;
import java.io.*;


public class ParallelStreamPuzzle3 {

    public static void main(String[] args) throws IOException {

        List<Integer> x = IntStream.range(0, 30)
                .peek(e -> System.out.println(e + ": " + Thread.currentThread().getName()))
                .limit(10)
                .parallel()
                .boxed()
                .collect(Collectors.toList());
        System.out.println(x);
    }

}
