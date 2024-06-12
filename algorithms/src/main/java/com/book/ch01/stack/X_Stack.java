package com.book.ch01.stack;

import java.util.Iterator;

public class X_Stack<Item> implements Iterable<Item> {

    private Node first;
    private int N;

    public boolean isEmpty() {
        return N == 0; // first != null;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node node = first;
        @Override
        public Item next() {
            Item item = node.item;
            node = node.next;
            return item;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }
    }

    private class Node {
        Item item;
        Node next;
    }
}
