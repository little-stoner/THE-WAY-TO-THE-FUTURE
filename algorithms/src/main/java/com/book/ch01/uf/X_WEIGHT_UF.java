package com.book.ch01.uf;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class X_WEIGHT_UF {

    private int[] id;
    private int[] weight;
    private int count;

    public X_WEIGHT_UF(int n) {
        count = n;
        id = new int[n];
        weight = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        for (int i = 0; i < n; i++) {
            weight[i] = 1;
        }
    }

    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);

        if (weight[pid] < weight[qid]) {
            id[pid] = qid;
            weight[qid] += weight[pid];
        } else {
            id[qid] = pid;
            weight[pid] += weight[qid];
        }

        count--;
    }

    public int find(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int count() {
        return count;
    }

    public static void timeUF(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        int N = scanner.nextInt();
        X_WEIGHT_UF uf = new X_WEIGHT_UF(N);
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
        }
        StdOut.println(uf.count() + " components");
    }

    public static void main(String[] args) throws FileNotFoundException {
        String file = "/Users/viber/Mamba/course/algs4-data/tinyUF.txt";
        String mfile = "/Users/viber/Mamba/course/algs4-data/mediumUF.txt";
        String lfile = "/Users/viber/Mamba/course/algs4-data/largeUF.txt";

        Stopwatch stopwatch = new Stopwatch();
        System.out.println(" >>>>>>>>> start <<<<<<<<<");
        timeUF(file);
        System.out.println(" >>>>>>>>> " + stopwatch.elapsedTime() + " <<<<<<<<<");
        stopwatch = new Stopwatch();
        timeUF(mfile);
        System.out.println(" >>>>>>>>> " + stopwatch.elapsedTime() + " <<<<<<<<<");
        stopwatch = new Stopwatch();
        timeUF(lfile);
        System.out.println(" >>>>>>>>> " + stopwatch.elapsedTime() + " <<<<<<<<<");
    }

    public static void main0(String[] args) throws FileNotFoundException {
        String file = "/Users/viber/Mamba/course/algs4-data/tinyUF.txt";
        Scanner scanner = new Scanner(new File(file));
        Stopwatch stopwatch = new Stopwatch();
        System.out.println(" >>>>>>>>> start <<<<<<<<<");
        int N = scanner.nextInt();
        // int N = StdIn.readInt();
        X_WEIGHT_UF uf = new X_WEIGHT_UF(N);
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (uf.connected(p, q)) {
                continue;
            }
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
        System.out.println(" >>>>>>>>> " + stopwatch.elapsedTime() + " <<<<<<<<<");
    }

}
