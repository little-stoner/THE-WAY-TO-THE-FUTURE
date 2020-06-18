package _concurrent;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.LongStream.*;
import static java.util.concurrent.TimeUnit.*;
import java.io.*;
import java.nio.file.*;


public class ParallelPrime {

    static final int COUNT = 100000;
    public static boolean isPrime(long n) {
        return rangeClosed(2, (long)Math.sqrt(n)).
            noneMatch(i -> n % i == 0);
    }

    public static long duration(long start) {
        return NANOSECONDS.toMillis(System.nanoTime() - start);
    }

    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        List<String> primes = iterate(2, i -> i + 1)
            .parallel() // which make the stream to parallel (you can comment this to compare the time)
            .filter(ParallelPrime::isPrime)
            .limit(COUNT)
            .mapToObj(Long::toString)
            .collect(Collectors.toList());
        System.out.println(" spend time: " + duration(start));
        Files.write(Paths.get("E:\\VI\\JAVA-BASIC\\src\\main\\java\\_concurrent\\prime.txt"), primes, StandardOpenOption.CREATE);
            
    }
    
}
