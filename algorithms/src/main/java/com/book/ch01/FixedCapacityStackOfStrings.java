package com.book.ch01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FixedCapacityStackOfStrings {

    private String[] array;
    private int index;
    public FixedCapacityStackOfStrings(int cap) {
        array = new String[cap];
        index = 0;
    }
    public void push(String item) {
        array[index++] = item;
    }
    public String pop() {
        return array[--index];
    }
    public boolean isEmpty() {
        return index == 0;
    }
    public int size() {
        return index;
    }

    public static void main(String[] args) {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            }
            else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }

}
