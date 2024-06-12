package com.book.ch02.merge;

import com.book.ch02.BaseSort;
import edu.princeton.cs.algs4.Insertion;

public class Merge<E extends Comparable<E>> extends BaseSort {

    private static int CUTOFF = 7;
    private E[] aux;
    @Override
    @SuppressWarnings("unchecked")
    public <T extends Comparable<T>> void doSort(T[] a) {
        aux = (E[]) new Comparable[a.length];
        mergeSort((E[]) a, 0, a.length - 1);
    }
    private void mergeSort(E[] a, int lo, int hi) {
        if (lo >= hi) return;
        // use insert sort for small array
        if (hi <= lo + CUTOFF - 1) {
            Insertion.sort(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid+1, hi);
        //
        if (!less(a[mid+1], a[mid])) {
            return;
        }
        merge(a, lo, mid, hi);
    }

    @SuppressWarnings("unchecked")
    private void BU(E[] a) {
        int N = a.length;
        aux = (E[]) new Comparable[N];
        for (int sz=1; sz < N; sz += sz) {
            for (int lo=0; lo < N - sz; lo += sz+sz) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
            }
        }
    }

    private void merge(E[] a, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        new Merge<String>().<String>sort();
    }

}
