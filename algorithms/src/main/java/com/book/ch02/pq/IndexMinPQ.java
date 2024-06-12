package com.book.ch02.pq;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexMinPQ<Item extends Comparable<Item>> implements Iterable<Integer> {

    private int[] pq;
    private int qp[];
    private Item keys[];
    private int maxN;
    private int n;
    public IndexMinPQ(int maxN) {
        this.maxN = maxN;
        n = 0;
        pq = new int[maxN+1];
        qp = new int[maxN+1];  // inverse of pq ---> qp[pq[i]] = pq[qp[i]] = i
        keys = (Item[]) new Comparable[maxN+1];
        for (int i=0; i <= maxN; i++) {
            qp[i] = -1;
        }
    }

    void insert(int i, Item item) {
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = item;
        swim(n);
    }

    @Deprecated
    public void change(int i, Item key) {
        changeKey(i, key);
    }
    public void changeKey(int i, Item key) {
        // validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }
    boolean contains(int k) {
        return qp[k] != -1;
    }
    public void delete(int i) {
        // validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        int index = qp[i];
        exch(index, n--);
        swim(index);
        sink(index);
        keys[i] = null;
        qp[i] = -1;
    }
    Item min() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        return keys[pq[1]];
    }
    int minIndex() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }
    int delMin() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        int min = pq[1];
        exch(1, n--);
        sink(1);
        assert min == pq[n+1];
        qp[min] = -1;        // delete
        keys[min] = null;    // to help with garbage collection
        pq[n+1] = -1;        // not needed
        return min;
    }
    boolean isEmpty() {
        return n == 0;
    }
    int size() {
        return n;
    }
    public Item keyOf(int i) {
        // validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        else return keys[i];
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }


    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public Iterator<Integer> iterator() { return new HeapIterator(); }

    private class HeapIterator implements Iterator<Integer> {
        // create a new pq
        private IndexMinPQ<Item> copy;

        // add all elements to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            copy = new IndexMinPQ<Item>(pq.length - 1);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i], keys[pq[i]]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMin();
        }
    }
    public void snapshot() {
        System.out.println(">>>>>> pq: " + Arrays.toString(pq));
        System.out.println(">>>>>> qp: " + Arrays.toString(qp));
        System.out.println(">>>>>> keys: " + Arrays.toString(keys));
        System.out.println("======================================================================================");
    }

    public static void main(String[] args) {
        // insert a bunch of strings
        String[] strings = { "it", "was", "the", "best", "of", "times", "it", "was", "the", "worst" };

        IndexMinPQ<String> pq = new IndexMinPQ<>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);

        }

        // delete and print each key
        while (!pq.isEmpty()) {
            int i = pq.delMin();
            pq.snapshot();
            StdOut.print(i + " " + strings[i]);
            StdOut.print(" | ");
        }
        StdOut.println();

        // reinsert the same strings
        for (int i = 0; i < strings.length; i++) {
            pq.insert(i, strings[i]);
        }

        // print each key using the iterator
        for (int i : pq) {
            StdOut.print(i + " " + strings[i]);
            StdOut.print(" | ");
        }
        while (!pq.isEmpty()) {
            pq.delMin();
        }

    }
}
