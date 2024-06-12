package com.book.ch01._1_4_analysis;

import com.book.ch01._1_4_analysis.ThreeSum;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingRatio {

    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i=0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch stopwatch = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return stopwatch.elapsedTime();
    }

    public static void main(String[] args) {
        double prev = timeTrial(125);
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%6d %7.1f ", N , time);
            StdOut.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }

}
