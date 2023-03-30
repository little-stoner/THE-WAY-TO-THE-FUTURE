package com.book.ch02;

public class Shell extends BaseSort {

    @Override
    public <T extends Comparable<T>> void doSort(T[] a) {
        int N = a.length;
        int h = 1;
        while (h < N) {
            h = 3 * h + 1;
        }
        while (h > 0) {
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
