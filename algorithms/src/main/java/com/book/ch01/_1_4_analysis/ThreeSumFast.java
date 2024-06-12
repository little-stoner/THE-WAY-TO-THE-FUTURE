package com.book.ch01._1_4_analysis;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class ThreeSumFast {

    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i=0; i < N; i++) {
            for (int j=i+1; j < N; j++) {
                if (BinarySearch.rank(-a[i]-a[j], a) > j) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] allInts = new In("/Users/viber/Mamba/algs4-data/1Kints.txt").readAllInts();

        Stopwatch stopwatch = new Stopwatch();
        System.out.println(">>>>> count: " + count(allInts));
        System.out.println(">>>>>>>>>> " + stopwatch.elapsedTime());
        allInts = new In("/Users/viber/Mamba/algs4-data/2Kints.txt").readAllInts();
        stopwatch = new Stopwatch();
        System.out.println(">>>>> count: " + count(allInts));
        System.out.println(">>>>>>>>>> " + stopwatch.elapsedTime());
        allInts = new In("/Users/viber/Mamba/algs4-data/4Kints.txt").readAllInts();
        stopwatch = new Stopwatch();
        System.out.println(">>>>> count: " + count(allInts));
        System.out.println(">>>>>>>>>> " + stopwatch.elapsedTime());
        allInts = new In("/Users/viber/Mamba/algs4-data/8Kints.txt").readAllInts();
        stopwatch = new Stopwatch();
        System.out.println(">>>>> count: " + count(allInts));
        System.out.println(">>>>>>>>>> " + stopwatch.elapsedTime());

    }

}
