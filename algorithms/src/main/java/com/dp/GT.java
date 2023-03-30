package com.dp;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashMap;
import java.util.Map;

public class GT {

    public static int gridTraveler(int m, int n) {
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        return gridTraveler(m-1, n) + gridTraveler(m, n-1);
    }

    private static Map<String, Integer> memo = new HashMap<>();

    public static int gridTraveler0(int m, int n) {
        String key = m + "," + n;
        if (memo.containsKey(key)) return memo.get(key);
        key = n + "," + m;
        if (memo.containsKey(key)) return memo.get(key);
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        int r = gridTraveler0(m-1, n) + gridTraveler0(m, n-1);
        memo.put(key, r);
        return r;
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        System.out.println(gridTraveler(30, 10));
        System.out.println(stopwatch.elapsedTime());
        stopwatch = new Stopwatch();
        System.out.println(gridTraveler0(30, 10));
        System.out.println(stopwatch.elapsedTime());
    }

}
