package _onjava8._concurrent;

import java.util.*;
import java.util.function.*;
import java.io.*;

import _onjava.Timer;


public class Summing2 {

    static void timeTest(String id, long checkValue, LongSupplier operation) {
        System.out.println(id + " : ");
        Timer timer = new Timer();
        long result = operation.getAsLong();
        if (result == checkValue)
            System.out.println(timer.duration() + " ms");
        else
            System.out.format("result: %d%n checkValue: %d%n", result, checkValue);
    }

    static long basicSum(long[] ia) {
        long sum = 0;
        int size = ia.length;
        for (int i = 0; i < size; i++) {
            sum += ia[i];
        }
        return sum;
    }

    public static final int SZ = 100000000;
    public static final long CHECK = (long) SZ * ((long) SZ + 1) / 2;

    public static void main(String[] args) throws IOException {
        System.out.println("CHECK : " + CHECK);

        long[] la = new long[SZ + 1];
        Arrays.parallelSetAll(la, i -> i);

        timeTest("Array Stream", CHECK, () -> Arrays.stream(la).sum());

        timeTest("Array Stream Parallel", CHECK, () -> Arrays.stream(la).parallel().sum());

        timeTest("Basic Sum", CHECK, () -> basicSum(la));

        timeTest("parallelPrefix", CHECK, () -> {
            Arrays.parallelPrefix(la, Long::sum);
            return la[la.length - 1];
        });

    }

}
