package com.book.ch02.pq;


import edu.princeton.cs.algs4.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author viber
 */
public class TopM {

    public static void main(String[] args) throws FileNotFoundException {
        // int M = Integer.parseInt(args[0]);
        int M = 5;
        Scanner scanner = new Scanner(new File("/Users/viber/Mamba/algs4-data/tinyBatch.txt"));
        MinPQ<Transaction> pq = new MinPQ<>(M+1);
        while (scanner.hasNextLine()) {
            pq.insert(new Transaction(scanner.nextLine()));
            if (pq.size() > M) {
                pq.delMin();
            }
        }
        Stack<Transaction> stack = new Stack<>();
        while (!pq.isEmpty()) {
            stack.push(pq.delMin());
        }
        for (Transaction t : stack) {
            StdOut.println(t);
        }
    }

}
