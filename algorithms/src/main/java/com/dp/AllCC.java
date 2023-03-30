package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllCC {

    public static List<List<String>> allConstruct(String target,
                                                  List<String> strings) {
        List<List<String>>[] table = new List[target.length() + 1];

        for (int i=0; i < table.length; i++) {
            table[i] = new ArrayList<>();
        }

        table[0].add(new ArrayList<>());

        for (int i = 0; i <= target.length(); i++) {
            for (String s : strings) {
                if (i + s.length() <= target.length()) {
                    if (s.equals(target.substring(i, i+s.length()))) {
                        List r = table[i].stream().map(sub -> {
                            List t = new ArrayList(sub);
                            t.add(s);
                            return t;
                        }).collect(Collectors.toList());
                        for (Object e : r) {
                            table[i + s.length()].add((List<String>) e);
                        }
                    }
                }
            }
        }

        return table[target.length()];

    }

    public static void main(String[] args) {
        System.out.println(allConstruct("purple", Arrays.asList("purp", "p", "ur", "le", "purpl")));
        System.out.println(allConstruct("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c")));
        System.out.println(allConstruct("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar")));

    }

}
