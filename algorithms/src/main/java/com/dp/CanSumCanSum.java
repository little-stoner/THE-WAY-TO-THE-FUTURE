package com.dp;

import java.util.Arrays;
import java.util.List;

public class CanSumCanSum {

    public static boolean canSum(int target, List<Integer> numbers) {

        boolean[] table = new boolean[target+1];

        table[0] = true;

        System.out.println(Arrays.toString(table));

        for (int i=0; i <= target; i++) {
            if (table[i]) {
                for (int n : numbers) {
                    if (i + n <= target) {
                        table[i + n] = true;
                    }
                }
            }
        }
        System.out.println("++++++++++++++++++++++++");
        System.out.println(Arrays.toString(table));

        return table[target];

    }

    public static void main(String[] args) {
        System.out.println(canSum(7, Arrays.asList(5,3,4,7)));
    }

}
