package com.book.ch01;

import java.util.Iterator;

public class ResizeingArrayStack<Item> implements Iterable<Item> {

    @SuppressWarnings("unchecked")
    private Item[] array = (Item[]) new Object[1];

    private int N = 0;

    public ResizeingArrayStack() {
    }
    public void push(Item item) {
        if (N == array.length) {
            resize( 2 * N );
        }
        array[N++] = item;
    }
    public Item pop() {
        Item item =  array[--N];
        array[N] = null;
        if (N > 0 && N == array.length/4) {
            resize(array.length/2);
        }
        return item;
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N == 0;
    }

    @SuppressWarnings("unchecked")
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i=0; i < N; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
    private class ReverseArrayIterator implements Iterator<Item> {
        public boolean hasNext() {
            return N > 0;
        }
        public Item next() {
            return array[--N];
        }
        public void remove() {

        }
    }
}
