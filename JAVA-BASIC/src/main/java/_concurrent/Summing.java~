package _concurrent;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.io.*;
import _onjava.Timer;


public class Summing {

    static void timeTest(String id, long checkValue, LongSupplier operation) {
        System.out.println(id + " : ");
        Timer timer = new Timer();
        long result = operation.getAsLong();
        if (result == checkValue)
            System.out.println(timer.duration() + " ms");
        else
            System.out.format("result: %d%n checkValue: %d%n", result, checkValue);
    }

    public static final int SZ = 1000000000;
    public static final long CHECK = (long)SZ * ((long)SZ + 1)/2;
    
    public static void main(String[] args) throws IOException {
        System.out.println("CHECK : " + CHECK);

        timeTest("Sum Stream", CHECK, () -> LongStream.rangeClosed(0, SZ).sum());

        timeTest("Sum Stream Parallel", CHECK, () -> LongStream.rangeClosed(0, SZ).parallel().sum());

        timeTest("Sum Iterated", CHECK, () -> LongStream.iterate(0, i -> i + 1).limit(SZ+1).sum());
        
    }

}
