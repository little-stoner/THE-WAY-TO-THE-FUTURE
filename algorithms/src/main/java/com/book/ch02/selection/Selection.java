package com.book.ch02.selection;

import com.book.ch02.BaseSort;

public class Selection extends BaseSort {

    @Override
    public <T extends Comparable<T>> void doSort(T[] a) {
        int N = a.length;
        for (int i=0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        new Selection().<String>sort();
    }
}
