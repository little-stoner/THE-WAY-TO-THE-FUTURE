package com.book.ch02.insertion;

import com.book.ch02.BaseSort;

public class Insertion extends BaseSort {

    @Override
    public <T extends Comparable<T>> void doSort(T[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }

    public static void main(String[] args) {
        new Insertion().<String>sort();
    }


}
