package com.dp;

import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    public static boolean canSum(int r, int[] array) {
        if (r == 0) return true;
        if (r < 0) return false;
        for (int i=0; i < array.length; i++) {
            int remainder = r - array[i];
            if (canSum0(remainder, array)) {
                return true;
            }
        }
        return false;
    }

    private static Map<Integer, Boolean> memo = new HashMap<>();
    public static boolean canSum0(int r, int[] array) {
        if (memo.containsKey(r)) return memo.get(r);
        if (r == 0) return true;
        if (r < 0) return false;
        for (int i=0; i < array.length; i++) {
            int remainder = r - array[i];
            if (canSum0(remainder, array)) {
                return true;
            }
        }
        memo.put(r, false);
        return false;
    }

    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        System.out.println(canSum(7, new int[]{2, 3}));
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSum(7, new int[]{2, 4}));
        System.out.println(canSum(8, new int[]{2, 3, 5}));
        System.out.println(canSum(300, new int[]{7, 14}));
        System.out.println(stopwatch.elapsedTime());

        stopwatch = new Stopwatch();
        System.out.println(canSum0(7, new int[]{2, 3}));
        System.out.println(canSum0(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSum0(7, new int[]{2, 4}));
        System.out.println(canSum0(8, new int[]{2, 3, 5}));
        System.out.println(canSum0(300, new int[]{7, 14}));
        System.out.println(stopwatch.elapsedTime());
    }

}
