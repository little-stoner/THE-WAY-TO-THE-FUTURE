package com.book.ch02;

import com.book.ch02.heap.Heap;
import com.book.ch02.insertion.Insertion;
import com.book.ch02.merge.Merge;
import com.book.ch02.quick.Quick;
import com.book.ch02.selection.Selection;
import com.book.ch02.shellsort.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {

    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) new Insertion().sort();
        if (alg.equals("Selection")) new Selection().sort();
        if (alg.equals("Shell")) new Shell().sort();
        if (alg.equals("Merge")) new Merge().sort();
        if (alg.equals("Quick")) new Quick().sort();
        if (alg.equals("Heap")) new Heap().sort();
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for ( int t = 0; t < T; t++ ) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();
            }
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Insertion", alg2 = "Selection";
        int N = 10000, T = 100;
        double t1 = timeRandomInput(alg1, N, T);
        double t2 = timeRandomInput(alg2, N, T);
        StdOut.printf(" For %d random Doubles\n    %s is", N, alg1);
        StdOut.printf(" %.1f times faster then %s\n", t2/t1, alg2);
    }

}
