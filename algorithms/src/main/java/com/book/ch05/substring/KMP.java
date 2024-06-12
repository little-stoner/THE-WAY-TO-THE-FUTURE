package com.book.ch05.substring;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class KMP {
    private String pat;
    private int[][] dfa;
    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[pat.charAt(j)][j] = j+1;
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) {
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M) return i - M;
        else return N;
    }

    public void printDFA() {
        System.out.println("========================================");
        for (int c = 0; c < 256; c++) {
            System.out.print( (char) c + " : " + Arrays.toString(dfa[c]));
            System.out.println();
        }
        System.out.println("========================================");
    }

    public static void main(String[] args) {
        // String pat = args[0];
        String pat = "ABABAC";
        // String txt = args[1];
        String txt = "ABABAC";
        // A : [1, 1, 3, 1, 5, 1]
        // B : [0, 2, 0, 4, 0, 4]
        // C : [0, 0, 0, 0, 0, 6]
        KMP kmp = new KMP(pat);
        StdOut.println(" text: " + txt);
        int offset = kmp.search(txt);
        StdOut.print(" pattern: ");
        for (int i=0; i < offset; i++) {
            StdOut.print(" ");
        }
        StdOut.println(pat);
    }
}
