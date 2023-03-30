package com.book.ch02;

public class Heap<E extends Comparable<E>> extends BaseSort {

    @Override
    public <T extends Comparable<T>> void doSort(T[] a) {
        heap((E[]) a);
    }

    private void sink(E[] pq, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(pq, j, j + 1))
                j++;
            if (!less(pq, k, j))
                break;
            exch0(pq, k, j);
            k = j;
        }
    }

    private void heap(E[] pq) {
        int n = pq.length;
        // heapify phase
        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n);
        }
        // sortdown phase
        int k = n;
        while (k > 1) {
            exch0(pq, 1, k--);
            sink(pq, 1, k);
        }
    }

    private boolean less(E[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    private void exch0(E[] pq, int i, int j) {
        E swap = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = swap;
    }

    public static void main(String[] args) {
        new Heap<>().<String>sort();
    }

}
