package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestSumBestSum {

    public static List<Integer> bestSum(int target, List<Integer> numbers) {
        List[] table = new List[target+1];
        table[0] = new ArrayList();

        for (int i=0; i <= target; i++) {
            if (table[i] != null) {
                for (int n : numbers) {
                    if (i + n <= target) {
                        List t = new ArrayList(table[i]);
                        t.add(n);
                        if (table[i+n] == null || (table[i + n].size() > t.size())) {
                            table[i + n] = new ArrayList(t);
                        }
                    }

                }
            }
        }

        return table[target];

    }

    public static void main(String[] args) {
        System.out.println(bestSum(8, Arrays.asList(1, 4, 5)));
        System.out.println(bestSum(100, Arrays.asList(1, 2, 5, 25)));
    }

}
