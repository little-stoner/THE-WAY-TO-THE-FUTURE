package com.book.ch01;

/**
 * @author viber
 */
public class FixedCapacityStack<Item> {
    private Item[] array;
    private int N;

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int cap) {
        array = (Item[]) new Object[cap];
    }
    public void push(Item item) {
        array[N++] = item;
    }
    public Item pop() {        
        Item item =  array[--N];
        return item;
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return N == 0;
    }

}
