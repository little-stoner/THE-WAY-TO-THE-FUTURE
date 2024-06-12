package com.book.ch02.pq;

public class MinPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public MinPQ() {}

    public MinPQ(int N) {
        pq = (Key[]) new Comparable[N+1];
    }

    public MinPQ(Key[] a) {
        pq = a;
        N = a.length;
    }

    public void insert(Key v) {
        pq[N++] = v;
        sink(N);
    }

    public Key min() {
        return pq[1];
    }

    public Key delMin() {
        Key min = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        swim(1);
        return min;
    }


    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }
    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(j, k)) break;
            exch(k, j);
            k = j;
        }
    }

    private void sink(int k) {
        while (k/2 > 1 && less(k, k/2)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    public static void main(String[] args) {

    }


}
