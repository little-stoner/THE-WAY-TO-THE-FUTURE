package _streams;

import java.util.Arrays;

public class ArrayStreams {

    public static void main(String[] args) {
        Arrays.stream(
                new double[] { 3.1415926, 2.718, 1.618 }
        ).forEach(n -> System.out.format("%f ", n));

    }

}
