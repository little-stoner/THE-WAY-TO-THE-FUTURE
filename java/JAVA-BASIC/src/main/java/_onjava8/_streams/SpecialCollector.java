package _onjava8._streams;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SpecialCollector {
    public static void main(String[] args) throws Exception {

        ArrayList<String> words =
                FileToWords.stream("Cheese.dat")
                .collect(ArrayList::new,
                        ArrayList::add,
                        ArrayList::addAll);
        words.stream()
                .filter(s -> s.equals("cheese"))
                .forEach(System.out::println);

    }
}
