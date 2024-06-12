package com.book.ch01._1_4_analysis;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;


//For i = 0, j = 1, k will execute for 2 to N-1 ie if statement will execute for N-2 times.
//For i = 0, j = 2, k will execute for 3 to N-1 ie if statement will execute for N-3 times.
//:
//:
//For i = 0, j = N-2, k will execute for N-1 to N-1 ie if statement will execute for 1 times.
//
//That means for i = 0, if statement will execute for :
//N-2 + N-3 + .... +1 = (N-2)(N-1)/2.
//
//For i = 1, j = 2, k will execute for 3 to N-1 ie if statement will execute for N-3 times.
//For i = 1, j = 3, k will execute for 4 to N-1 ie if statement will execute for N-4 times.
//:
//:
//For i = 1, j = N-2, k will execute for N-1 to N-1 ie if statement will execute for 1 times.
//
//And for i = 1, if statement will execute for :
//N-3 + N-4 + .... +1 = (N-3)(N-2)/2.
//
//*
//*
//For i = N-4, j = N-3, k will execute for N-2 to N-1 ie if statement will execute for 2 times.
//For i = N-4, j = N-2, k will execute for N-1 to N-1 ie if statement will execute for 1 times.
//
//And for i = N-4, if statement will execute for :
//2+1 = (2)(3)/2.
//
//For i = N-3, j = N-2, k will execute for N-1 to N-1 ie if statement will execute for 1 times.
//For i = N-3, j = N-1, k will fail for condition ie if statement will execute for 0 times.
//ie (1)(1+1)/2
//
//And for i = N-3, if statement will execute for :
//1 = (1)(2)/2.
//
//ie.
//i = 0, if statement will execute for (N-2)(N-1)/2
//i = 1, if statement will execute for (N-3)(N-2)/2
//i = 2, if statement will execute for (N-4)(N-3)/2
//.
//.
//i = N-5, if statement will execute for (3*4)/2
//i = N-4, if statement will execute for (2*3)/2
//i = N-3, if statement will execute for (1*2)/2
//
// 1^2+2^2+3^2+...+n^2=𝑛(𝑛+1)(2𝑛+1)/6
//That means total number of times if statement executed is
//= (N-2)(N-1)/2 + (N-3)(N-2)/2 + (N-4)(N-3)/2 + ... + (2)(3)/2 + (1)(2)/2
//= (1/2)[ 1*2 + 2*3 + 3*4 + ... + (N-2)(N-1) ]
//= (1/2)[2^2-2 + 3^2-3 + 4^2-4 + ... + (N-1)^2-(N-1)]
//= (1/2)[(2^2+3^2+4^2+...+(N-1)^2) - (2+3+4+...+(N-1)]
//= (1/2)[(1^2+2^2+3^2+...+(N-1)^2) - (1+2+....+(N-1)]
//= (1/2)[ (N-2)(N-1)(N)/3 ]
//= (N)(N+1)(N+2)/6
public class ThreeSum {

    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i=0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] allInts = new In("/Users/viber/Mamba/algs4-data/1Kints.txt").readAllInts();

        Stopwatch stopwatch = new Stopwatch();
        System.out.println(">>>>> count: " + count(allInts));
        System.out.println(">>>>>>>>>> " + stopwatch.elapsedTime());
        allInts = new In("/Users/viber/Mamba/algs4-data/2Kints.txt").readAllInts();
        stopwatch = new Stopwatch();
        System.out.println(">>>>> count: " + count(allInts));
        System.out.println(">>>>>>>>>> " + stopwatch.elapsedTime());
        allInts = new In("/Users/viber/Mamba/algs4-data/4Kints.txt").readAllInts();
        stopwatch = new Stopwatch();
        System.out.println(">>>>> count: " + count(allInts));
        System.out.println(">>>>>>>>>> " + stopwatch.elapsedTime());
        allInts = new In("/Users/viber/Mamba/algs4-data/8Kints.txt").readAllInts();
        stopwatch = new Stopwatch();
        System.out.println(">>>>> count: " + count(allInts));
        System.out.println(">>>>>>>>>> " + stopwatch.elapsedTime());

    }

}
