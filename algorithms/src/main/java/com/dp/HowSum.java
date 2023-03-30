package com.dp;

import java.util.*;

public class HowSum {

    public static List<Integer> howSum(int target, List<Integer> numbers) {
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        for (Integer n : numbers) {
            int remainder = target - n;
            List<Integer> rr = howSum(remainder, numbers);
            if (rr != null) {
                rr.add(n);
                return rr;
            }
        }
        return null;
    }

    private static Map<Integer, List<Integer>> memo = new HashMap<>();
    public static List<Integer> howSum0(int target, List<Integer> numbers) {

        if (memo.containsKey(target)) return memo.get(target);

        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;
        for (Integer n : numbers) {
            int remainder = target - n;
            List<Integer> rr = howSum(remainder, numbers);
            if (rr != null) {
                rr.add(n);
                memo.put(target, rr);
                return rr;
            }
        }
        memo.put(target, null);
        return null;
    }

    public static void main(String[] args) {
        System.out.println(howSum(7, Arrays.asList(2, 3)));
        System.out.println(howSum( 7, Arrays.asList(5, 3, 4, 7)));
        System.out.println(howSum( 7, Arrays.asList(2, 4)) );
        System.out.println(howSum( 8, Arrays.asList(2, 3, 5)));
        System.out.println(howSum( 300, Arrays.asList(7, 14)) );
        System.out.println("=================");
        System.out.println(howSum0(7, Arrays.asList(2, 3)));
        System.out.println(howSum0( 7, Arrays.asList(5, 3, 4, 7)));
        System.out.println(howSum0( 7, Arrays.asList(2, 4)) );
        System.out.println(howSum0( 8, Arrays.asList(2, 3, 5)));
        System.out.println(howSum0( 300, Arrays.asList(7, 14)) );
    }

}
