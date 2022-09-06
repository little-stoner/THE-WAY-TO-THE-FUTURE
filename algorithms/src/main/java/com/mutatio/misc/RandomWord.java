package com.mutatio.misc;

import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

public class RandomWord {

    public static void main(String[] args) {
        Random random = new Random();
        StdOut.println(random.nextInt(99));
    }
}
