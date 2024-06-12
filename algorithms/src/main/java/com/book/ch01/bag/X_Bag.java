package com.book.ch01.bag;

import java.util.Iterator;

public class X_Bag<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int N;

    public X_Bag() {}

    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public int size() {
        return N;
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {}

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
