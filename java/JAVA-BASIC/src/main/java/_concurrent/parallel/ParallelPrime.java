package _concurrent.parallel;

import _onjava.Timer;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.LongStream.iterate;

public class ParallelPrime {

    static final int COUNT = 100_000;
    public static boolean isPrime(long n) {
        return java.util.stream.LongStream.rangeClosed(2, (long) Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }

    public static void main(String[] args) throws Exception {
        Timer timer = new Timer();
        List<String> primes = iterate(2, i -> i + 1)
                .parallel()
                .filter(ParallelPrime::isPrime)
                .limit(COUNT)
                .mapToObj(Long::toString)
                .collect(Collectors.toList());
        System.out.println(timer.duration());
        timer = new Timer();
        primes = iterate(2, i -> i + 1)
                .filter(ParallelPrime::isPrime)
                .limit(COUNT)
                .mapToObj(Long::toString)
                .collect(Collectors.toList());
        System.out.println(timer.duration());

    }

}
