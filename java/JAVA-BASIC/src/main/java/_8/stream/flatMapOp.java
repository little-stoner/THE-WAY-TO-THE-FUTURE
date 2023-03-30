package _8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class flatMapOp {

    public static List<String> words = Arrays.asList("Modern", "Java", "In", "Action");

    public static void main(String[] args) {

        List<String[]> wordLengths = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(wordLengths);

        List<String> wordLengths0 = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(wordLengths0);

    }

}
