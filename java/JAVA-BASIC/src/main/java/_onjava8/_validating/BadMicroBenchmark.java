package _onjava8._validating;

import _onjava.Timer;

import java.util.ArrayList;
import java.util.Arrays;

public class BadMicroBenchmark {
    static final int SIZE = 250_000_000;

    public static void main(String[] args) {
        try {
            long[] la = new long[SIZE];
            System.out.println(" setAll: " +
                    Timer.duration(() -> Arrays.setAll(la, n -> n)));
            System.out.println(" parallelSetAll: " +
                    Timer.duration(() -> Arrays.parallelSetAll(la, n -> n)));
        } catch (OutOfMemoryError error) {
            System.out.println(" Insufficient memory ");
            System.exit(0);
        }
    }
}
