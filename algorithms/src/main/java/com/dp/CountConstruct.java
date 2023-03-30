package com.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountConstruct {

    public static int countConstruct(String target, List<String> strings) {
        if (target.length() == 0) return 1;

        int total = 0;
        for (String s : strings) {
            if (target.indexOf(s) == 0) {
                String suffix = target.substring(s.length());
                int r = countConstruct(suffix, strings);
                total += r;
            }
        }
        return total;
    }
    private static Map<String, Integer> memo = new HashMap<>();
    public static int countConstruct0(String target, List<String> strings) {
        if (memo.containsKey(target)) return memo.get(target);

        if (target.length() == 0) return 1;

        int total = 0;
        for (String s : strings) {
            if (target.indexOf(s) == 0) {
                String suffix = target.substring(s.length());
                int r = countConstruct0(suffix, strings);
                total += r;
            }
        }
        memo.put(target, total);
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countConstruct("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
        System.out.println(countConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println(countConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(countConstruct("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));
        System.out.println(countConstruct0("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
    }


}
