package com.dp;

import java.util.Arrays;
import java.util.List;

public class CanCCC {

    public static boolean conConstruct(String target, List<String> strings) {
        boolean[] table = new boolean[target.length()+1];
        table[0] = true;
        for (int i=0; i < target.length(); i++) {
            if (table[i]) {
                for (String s : strings) {
                    if (i + s.length() <= target.length()) {
                        if (s.equals(target.substring(i, i + s.length()))) {
                            table[i + s.length()] = true;
                        }
                    }
                }
            }
        }
        return table[target.length()];
    }

    public static void main(String[] args) {
        System.out.println(conConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println(conConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(conConstruct("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));
    }

}
