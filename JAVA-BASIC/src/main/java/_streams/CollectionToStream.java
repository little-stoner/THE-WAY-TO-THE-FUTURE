package _streams;

import java.util.*;

public class CollectionToStream {

    public static void main(String[] args) {

        List<Bubble> bubbles = Arrays.asList(
                new Bubble(1),
                new Bubble(2),
                new Bubble(3)
        );


        System.out.println(bubbles.stream().mapToInt(b -> b.i).sum());

        Set<String> w = new HashSet<>(Arrays.asList(
                "It's a wonderful day for pie!".split(" ")
        ));

        w.stream()
                .map(x -> x + " " )
                .forEach(System.out::println);

        Map<String, Double> m = new HashMap<>();

        m.put("pi", 3.1415926);
        m.put("e", 2.718);

        m.entrySet().stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .forEach(System.out::println);



    }
}
