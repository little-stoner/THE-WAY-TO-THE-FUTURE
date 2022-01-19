package com.mutatio;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class QuickUnionUF {

    private int[] dot;
    private int count;

    public QuickUnionUF(int N) {
        dot = new int[N];
        count = N;
        for(int i = 0; i < N; i++) {
            dot[i]  = i;
        }
    }

    private boolean connected(int p, int q) {
        int P = root(p);
        int Q = root(q);
        if (P == Q) {
            return true;
        }
        return false;
    }

    private void union(int p, int q) {
        int P = root(p);
        int Q = root(q);
        if (P == Q) {
            return;
        }
        dot[P] = Q;
        count--;
    }

    private int root(int p) {
        int index = dot[p];
        return index == p ? index : root(index);
    }

    private void find(int p) {

    }

    private int count() {
        return count;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) { continue; }
            uf.union(p, q);
            StdOut.println(p + "  " + q);
        }
        StdOut.println(uf.count() +  " components ");
        System.out.println(Arrays.toString(uf.dot));
    }
}
