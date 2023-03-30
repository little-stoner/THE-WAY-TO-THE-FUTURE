package com.book.ch02;

public class Bubble extends BaseSort {

    @Override
    public <T extends Comparable<T>> void doSort(T[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (less(a[j + 1], a[j])) {
                    exch(a, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Bubble().<String>sort();
    }

}
