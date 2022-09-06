package _concurrent.parallel;

import java.util.Arrays;

public class Summing3 {

    static long basicSum(Long[] ia) {
        long sum = 0;
        int size = ia.length;
        for (int i=0; i < size; i++) {
            sum += ia[i];
        }
        return sum;
    }

    public static final int SZ = 10_000_000;
    public static final long CHECK = (long)SZ * ((long) SZ + 1)/2;

    public static void main(String[] args) {
        System.out.println(CHECK);
        Long[] la = new Long[SZ+1];
        Arrays.parallelSetAll(la, i -> (long) i);
        Summing.timeTest("Long Array Stream Sum", CHECK, () -> Arrays.stream(la).reduce(0L, Long::sum));
        Summing.timeTest("Long Parallel", CHECK, () -> Arrays.stream(la).parallel().reduce(0L, Long::sum));
        Summing.timeTest("Long Basic Sum", CHECK, () -> basicSum(la));
        Summing.timeTest("Long ParallelPrefix", CHECK, () -> {
            Arrays.parallelPrefix(la, Long::sum);
            return la[la.length - 1];
        });
    }

}
