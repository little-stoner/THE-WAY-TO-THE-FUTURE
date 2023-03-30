package com.book.ch02;

public class ES {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i=0; i < N; i++) {
            int min = i;
            for (int j=i+1; j < N; j++) {
                if (a[min].compareTo(a[j]) > 0) {
                    min = j;
                }
            }
            Comparable t = a[i];
            a[i] = a[min];
            a[min] = t;
        }
    }

    public static void main(String[] args) {
    }

}
