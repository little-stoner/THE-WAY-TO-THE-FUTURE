package com.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanConstruct {

    public static boolean conConstruct(String target, List<String> strings) {
        if (target.length() == 0) return true;
        for (String s : strings) {
            if (target.indexOf(s) == 0) {
                String suffix = target.substring(s.length());
                if (conConstruct(suffix, strings)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Map<String, Boolean> memo = new HashMap<>();
    public static boolean conConstruct0(String target, List<String> strings) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target.length() == 0) return true;

        for (String s : strings) {
            if (target.indexOf(s) == 0) {
                String suffix = target.substring(s.length());
                if (conConstruct0(suffix, strings)) {
                    memo.put(target, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(conConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println(conConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(conConstruct("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));
        System.out.println(conConstruct0("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee")));
        System.out.println("====================");
    }


}
