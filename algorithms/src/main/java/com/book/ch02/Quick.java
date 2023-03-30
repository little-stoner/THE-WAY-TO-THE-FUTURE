package com.book.ch02;

public class Quick<E extends Comparable<E>> extends BaseSort {

    @Override
    public <T extends Comparable<T>> void doSort(T[] a) {
        quickSort((E[]) a, 0, a.length - 1);
    }

    private void quickSort(E[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        quickSort(a, lo, j-1);
        quickSort(a, j+1, hi);
    }

    private int partition(E[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        E v = a[lo];
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

    private void threeWay(E[] a, int lo, int hi) {
        if (lo >= hi) return;
        int lt = lo, i = lo + 1, gt = hi;
        E v = a[lo];
        while ( i <= gt ) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        threeWay(a, lo, lt - 1);
        threeWay(a, gt + 1, hi);
    }

    public static void main(String[] args) {
        new Quick<>().<String>sort();
    }

}
