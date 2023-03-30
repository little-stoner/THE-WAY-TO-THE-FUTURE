package com.book.ch02;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Example {

    public static <T extends Comparable<T>> void es(T[] a) {
        int N = a.length;
        for (int i=0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static <T extends Comparable<T>> void bs(T[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (less(a[j + 1], a[j])) {
                    exch(a, j, j + 1);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void is(T[] a) {
        int N = a.length;
        for (int i=1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
    }
    public static <T extends Comparable<T>> void ss(T[] a) {
        int gap, i, j, n = a.length;
        for (gap = n/2; gap > 0; gap /= 2) {
            for (i = gap; i < n; i++) {
                // for (j = i - gap; j >= 0 && less(a[j+gap], a[j]); j -= gap) {
                //    exch(a, j, j+gap);
                // }
                for (j = i; j > 0 && less(a[j], a[j-gap]); j -= gap) {
                    exch(a, j, j-gap);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void sss(T[] a) {
        int h = 1, N = a.length;
        while (h < N/3) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for (int i=h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exch(a, j, j-h);
                }
            }
            h /= 3;
        }
    }

    public static <T extends Comparable<T>> void ms(T[] a) {
        int N = a.length;
        T[] copy = (T[]) new Comparable[N];
        mss(a, copy, 0, N-1);
    }
    public static <T extends Comparable<T>> void mss(T[] a, T[] c, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mss(a, c, lo, mid);
        mss(a, c, mid+1, hi);
        merge(a, c, lo, mid, hi);
    }
    public static <T extends Comparable<T>> void bupmss(T[] a) {
        int N = a.length;
        T[] copy = (T[]) new Comparable[N];
        for (int i=0; i < N; i++) {
            copy[i] = a[i];
        }
        for (int sz=1; sz < N; sz += sz) {
            for (int i=0; i < N-sz; i += (sz+sz)) {
                merge(a, copy, i, i+sz-1, Math.min(i+sz+sz-1, N-1));
            }
        }

    }
    public static <T extends Comparable<T>> void merge(T[] a, T[]  c, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            c[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = c[j++];
            }
            else if (j > hi) {
                a[k] = c[i++];
            }
            else if (less(c[j], c[i])) {
                a[k] = c[j++];
            }
            else {
                a[k] = c[i++];
            }
        }
    }

    public static <T extends Comparable<T>> void qs(T[] a) {
        qss(a, 0, a.length - 1);
    }
    public static <T extends Comparable<T>> void qss(T[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(a, lo, hi);
        qss(a, lo , j-1);
        qss(a, j+1, hi);
    }
    public static <T extends Comparable<T>> int partition(T[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        T v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) break;
            }
            while (less(v, a[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static <T extends Comparable<T>> void qs3(T[] a) {
        qd3(a, 0, a.length-1);
    }
    public static <T extends Comparable<T>> void qd3(T[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo, i = lo+1, gt = hi;
        T v = a[lo];
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        qd3(a, lo, lt -1 );
        qd3(a, gt + 1, hi);
    }

    public static <T extends Comparable<T>> void sort(T[] a) {
        ms(a);
        bupmss(a);
    }
    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }
    private static <T extends Comparable<T>> boolean equals(T v, T w) {
        return v.compareTo(w) == 0;
    }

    private static <T extends Comparable<T>> void exch(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static <T extends Comparable<T>> void show(T[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i=1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = new In("/Users/viber/Mamba/algs4-data/words3.txt").readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }


}
