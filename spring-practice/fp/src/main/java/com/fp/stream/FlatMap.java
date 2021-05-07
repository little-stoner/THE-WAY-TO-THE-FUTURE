package com.fp.stream;

import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap {

    public static void main(String[] args) {
        List<List<String>> namesNested = Arrays.asList(
            Arrays.asList("Jeff", "B"),
            Arrays.asList("Bill", "C"),
            Arrays.asList("Mark", "D")
        );
        System.out.println(namesNested);
        System.out.println(
                namesNested.stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList())
        );

        Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
        map.put("a", new HashMap<String, Integer>(){{put("A", 1);}});
        map.put("b", new HashMap<String, Integer>(){{put("B", 2);}});
        System.out.println(
                map.entrySet().stream().flatMap(e ->
                        e.getValue().entrySet().stream().flatMap(
                                v -> Stream.of(new AbstractMap.SimpleEntry(e.getKey() + "." + v.getKey(), v.getValue()))
                        )
                )
        );

    }

}
