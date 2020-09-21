package _efectivejava.generics;


import java.util.ArrayList;
import java.util.List;

public class Raw {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();

        unsafeAdd(strings, Integer.valueOf(42));

        // List<Object> and List<String>
        // unsafeAdd0(strings, Integer.valueOf(2));

        String s = strings.get(0);


    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    private static void unsafeAdd0(List<Object> list, Object o) {
        list.add(o);
    }



}
