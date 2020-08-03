package _efectivejava.generics.item32;

import java.util.List;

public class Dangerous {
    static void dangerous(List<String>... stringList) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringList;
        objects[0] = intList;
        String s = stringList[0].get(0);
    }

    public static void main(String[] args) {
        dangerous(List.of("There be dragons!"));
    }
}
