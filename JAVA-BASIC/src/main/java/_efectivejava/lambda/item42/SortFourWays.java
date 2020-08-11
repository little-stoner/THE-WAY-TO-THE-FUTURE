package _efectivejava.lambda.item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class
SortFourWays {

    public static void main(String[] args) {

        List<Integer> words = Arrays.asList(3, 9, 1, 0);
        Collections.sort(words, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        System.out.println(words);
        Collections.shuffle(words);

        Collections.sort(words, (s1, s2) -> Integer.compare(s1, s2));
        System.out.println(words);
        Collections.shuffle(words);

        Collections.sort(words, Comparator.comparingInt(Integer::intValue));
        System.out.println(words);
        Collections.shuffle(words);

        words.sort(Integer::compareTo);


    }




}
