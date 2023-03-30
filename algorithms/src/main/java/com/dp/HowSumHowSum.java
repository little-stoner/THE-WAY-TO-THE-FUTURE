package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowSumHowSum {

    @SuppressWarnings("unchecked")
    public static List<Integer> howSum(int target, List<Integer> numbers) {

        List[] table = new List[target+1];
        table[0] = new ArrayList();
        for (int i=0; i <= target; i++) {
            if (table[i] != null) {
                for (int n : numbers) {
                    if (i + n <= target) {
                        List t = new ArrayList(table[i]);
                        t.add(n);
                        table[n + i] = t;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(table));
        return table[target];
    }

    public static void main(String[] args) {
        System.out.println(howSum(7, Arrays.asList(5, 3, 4)));
    }
}
