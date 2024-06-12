package com.book.ch01.stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Reverse {

    public static void main(String[] args) {
        X_Stack<Integer> stack;
        stack = new X_Stack<>();
        while (!StdIn.isEmpty()) {
            stack.push(StdIn.readInt());
        }

        for (int i : stack) {
            StdOut.println(i);
        }
    }

}
