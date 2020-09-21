package _collections;

import java.util.Set;
import java.util.TreeSet;

public class SortedSetOfString {
    public static void main(String[] args) {
        Set<String> colors = new TreeSet<>();

        for (int i = 0; i < 100; i++){
            colors.add("Y");
            colors.add("X");
            colors.add("Red");
            colors.add("Blue");
            colors.add("Purple");
            colors.add("Orange");
        }

        System.out.println(colors);
    }
}
