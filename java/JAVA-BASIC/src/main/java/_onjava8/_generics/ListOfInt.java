package _onjava8._generics;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfInt {
    public static void main(String[] args) {
        List<Integer> li = IntStream.range(38, 48).boxed()
                .collect(Collectors.toList());
        System.out.println(li);
    }
}
