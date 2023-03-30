package com.dp;

import java.util.*;

public class AllConstruct {

    public static List<List<String>> allConstruct(String target,
                                                   List<String> strings) {
        if (target.length() == 0) {
            List<List<String>> r = new ArrayList<>();
            r.add(new ArrayList<String>());
            return r;
        }

        List<List<String>> result = new ArrayList<>();
        for (String s : strings) {
            if (target.indexOf(s) == 0) {
                String suffix = target.substring(s.length());
                List<List<String>> rrr = allConstruct(suffix, strings);
                if (rrr != null) {
                    List<List<String>> rrrr = new ArrayList<>(rrr);
                    rrrr.forEach(a -> a.add(s));
                    result.addAll(rrrr);
                }
            }
        }

        return result;
    }

    private static Map<String, List<List<String>>> memo = new HashMap<>();
    public static List<List<String>> allConstruct0(String target,
                                                   List<String> strings) {
        if (memo.containsKey(target)) return memo.get(target);

        if (target.length() == 0) {
            List<List<String>> r = new ArrayList<>();
            r.add(new ArrayList<String>());
            return r;
        }

        List<List<String>> result = new ArrayList<>();
        for (String s : strings) {
            if (target.indexOf(s) == 0) {
                String suffix = target.substring(s.length());
                List<List<String>> rrr = allConstruct0(suffix, strings);
                if (rrr != null) {
                    List<List<String>> rrrr = new ArrayList<>(rrr);
                    rrrr.forEach(a -> a.add(s));
                    result.addAll(rrrr);
                }
            }
        }
        memo.put(target, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(allConstruct("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
        System.out.println(allConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c")));
        System.out.println(allConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(allConstruct0("aaaaaaaaaaaaaaaaaaaaaaaaz", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa")));
        System.out.println("============================");
    }



}
