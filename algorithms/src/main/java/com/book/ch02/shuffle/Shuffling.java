package com.book.ch02.shuffle;

import com.book.ch02.BaseSort;
import edu.princeton.cs.algs4.StdRandom;

public class Shuffling extends BaseSort {


    @Override
    public <T extends Comparable<T>> void doSort(T[] a) {
        int N = a.length;
        for (int i=0; i < N; i++) {
            int r = StdRandom.uniformInt(i + 1);
            exch(a, i , r);
        }
    }

}
