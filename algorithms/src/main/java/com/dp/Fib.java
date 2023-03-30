package com.dp;

import java.util.HashMap;
import java.util.Map;

public class Fib {

    public static int f0(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        return f0(n-1) + f0(n-2);
    }

    private static Map<Integer, Integer> memo = new HashMap<>();
    public static int f1(int n) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n <= 2) {
            return 1;
        }
        int r = f1(n-1) + f1(n-2);
        memo.put(n, r);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(f1(20));
    }


}
