package com.dp;

import java.util.*;

public class BestSum {

    public static List<Integer> bestSum(int target, List<Integer> numbers) {
        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;

        List<Integer> r = null;
        for (Integer n : numbers) {
            int remainder = target - n;
            List<Integer> tt = bestSum(remainder, numbers);
            if (tt != null) {
                tt.add(n);
                if (r == null || r.size() > tt.size()) {
                    r = tt;
                }
            }
        }

        return r;
    }


    public static List<Integer> bestSum0(int target, List<Integer> numbers,
                                         Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) return memo.get(target);

        if (target == 0) return new ArrayList<>();
        if (target < 0) return null;

        List<Integer> r = null;
        for (Integer n : numbers) {
            int remainder = target - n;
            List<Integer> remainderCombination = bestSum0(remainder, numbers, memo);
            if (remainderCombination != null) {
                List<Integer> combination = new ArrayList<>(remainderCombination);
                combination.add(n);
                if (r == null || r.size() > combination.size()) {
                    r = combination;
                }
            }

        }
        memo.put(target, r);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(bestSum(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println(bestSum(8, Arrays.asList(2, 3, 5)));
        System.out.println(bestSum(8, Arrays.asList(1, 4, 5)));
        // System.out.println(bestSum(100, Arrays.asList(1, 2, 5, 25)));
        System.out.println("======================");
        Map<Integer, List<Integer>> memo = new HashMap<>();
        System.out.println(bestSum0(7, Arrays.asList(5, 3, 4, 7), memo));
        memo = new HashMap<>();
        System.out.println(bestSum0(8, Arrays.asList(2, 3, 5), memo));
        memo = new HashMap<>();
        System.out.println(bestSum0(8, Arrays.asList(1, 4, 5), memo));
        memo = new HashMap<>();
        System.out.println(bestSum0(100, Arrays.asList(1, 2, 5, 25), memo));

    }
}
