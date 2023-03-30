package com.book.ch01;

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author viber
 */
public class BinarySearch {
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) {
                // StdOut.printf(">>> lo: %d, hi: %d <<<\n", lo, hi);
                return mid;
            } else if (a[mid] < key) {
                lo = mid + 1;
            } else if (a[mid] > key) {
                hi = mid - 1;
            }
        }
        // StdOut.printf(">>> lo: %d, hi: %d <<<\n", lo, hi);
        return -1;
    }

    public static void main0(String[] args) throws FileNotFoundException {
        Stopwatch start = new Stopwatch();
        int[] whitelist = new In("/Users/viber/Mamba/algs4-data/largeW.txt").readAllInts();
        Arrays.sort(whitelist);
        Scanner scanner = new Scanner(
                new File("/Users/viber/Mamba/algs4-data/largeT.txt")
        );
        while (scanner.hasNextInt()) {
            int key = scanner.nextInt();
            if (rank(key, whitelist) < 0) {
                StdOut.println(key);
            }
        }
        System.out.println(" time: " + (start.elapsedTime()));

    }

    public static void main(String[] args) {
        int[] a = {8, 5, 9, 12};
        Arrays.sort(a);
        rank(6, a);
        StdOut.println("============================================");
        rank(1, a);
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        a = new int[]{2, 0, 4, 1, 2,};
        Arrays.sort(a);
        rank(90, a);
    }
}
