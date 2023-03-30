package com.dp;

import java.util.Arrays;
import java.util.List;

public class CountCCC {

    public static int countConstruct(String target, List<String> strings) {
        int[] table = new int[target.length()+1];
        table[0] = 1;

        for (int i=0; i < target.length(); i++) {
             for (String s : strings) {
                 if (i + s.length() <= target.length()) {
                     if (s.equals(target.substring(i, i + s.length()))) {
                         table[i + s.length()] += table[i];
                     }
                 }
             }
        }

        return table[target.length()];
    }

    public static void main(String[] args) {
        System.out.println(countConstruct("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
        System.out.println(countConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd")));
        System.out.println(countConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));
        System.out.println(countConstruct("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t")));
    }

}
