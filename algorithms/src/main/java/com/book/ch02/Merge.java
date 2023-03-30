package com.book.ch02;

public class Merge<E extends Comparable<E>> extends BaseSort {

    private E[] aux;
    @Override
    public <T extends Comparable<T>> void doSort(T[] a) {
        aux = (E[]) new Comparable[a.length];
        mergeSort((E[]) a, 0, a.length - 1);
    }
    private void mergeSort(E[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

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
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
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
