package _8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class intro {

    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();
        Collections.sort(ints, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        List<Integer> sortInts = ints.stream().sorted().collect(Collectors.toList());

    }

}
