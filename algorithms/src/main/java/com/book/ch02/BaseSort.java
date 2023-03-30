package com.book.ch02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public abstract class BaseSort {

    public abstract <T extends Comparable<T>> void doSort(T[] a);

    public <T extends Comparable<T>> void sort() {
        String[] a = new In("/Users/viber/Mamba/algs4-data/words3.txt").readAllStrings();
        doSort(a);
        // assert isSorted(a);
        show(a);
    }
    public <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }
    public <T extends Comparable<T>> boolean equals(T v, T w) {
        return v.compareTo(w) == 0;
    }

    public <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public <T extends Comparable<T>> void show(T[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i=1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }


}
