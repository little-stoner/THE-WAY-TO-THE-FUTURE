package com.book.ch02.shellsort;

import com.book.ch02.BaseSort;

public class Shell extends BaseSort {

    @Override
    public <T extends Comparable<T>> void doSort(T[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        new Shell().<String>sort();
    }

}
