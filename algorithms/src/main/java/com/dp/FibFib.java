package com.dp;

public class FibFib {

    public static int fib(int n) {
        int[] table = new int[n+1];
        table[1] = 1;
        for (int i=0; i <= n; i++) {
            table[i+1] = table[i];
            table[i+2] = table[i];
        }
        return table[n];
    }

}
