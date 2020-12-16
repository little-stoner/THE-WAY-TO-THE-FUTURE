package _onjava8._collections;

import java.util.Set;
import java.util.TreeSet;

public class SortedSetOfString {

    public static void main(String[] args) {
        Set<String> colors = new TreeSet<>();
        for (int i=0; i < 100; i++) {
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Orange");
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Purple");
        }
        System.out.println(colors);
    }

}
