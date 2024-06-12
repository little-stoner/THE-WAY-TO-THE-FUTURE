package com.book.ch01.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class X_FixedCapacityStackOfStrings {
    private int N;
    private final String[] stack;

    public X_FixedCapacityStackOfStrings(int cap) {
        stack = new String[cap];
    }

    public void push(String item) {
        stack[N++] = item;
    }

    public String pop() {
        return stack[--N];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        X_FixedCapacityStackOfStrings s = new X_FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + " ");
            }
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }

}
