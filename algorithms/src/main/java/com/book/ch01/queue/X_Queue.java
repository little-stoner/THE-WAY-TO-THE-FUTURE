package com.book.ch01.queue;

import edu.princeton.cs.algs4.In;

import java.util.Iterator;

public class X_Queue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;
    private class Node {
        Item item;
        Node next;
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static int[] readInts(String name) {
        In in = new In(name);
        X_Queue<Integer> q = new X_Queue<>();
        while (!in.isEmpty()) {
            q.enqueue(in.readInt());
        }
        int N = q.size();
        int[] a = new int[N];
        for (int i=0; i < N; i++) {
            a[i] = q.dequeue();
        }
        return a;
    }

}
