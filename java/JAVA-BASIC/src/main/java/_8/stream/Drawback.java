package _8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Drawback {

    public static void main(String[] args) {
        List<String> title = Arrays.asList("Modern", "Java", "In", "Action");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);
    }

}
