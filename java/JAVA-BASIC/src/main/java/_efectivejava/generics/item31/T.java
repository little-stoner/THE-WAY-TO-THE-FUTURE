package _efectivejava.generics.item31;

import java.util.ArrayList;
import java.util.List;

public class T {

    public static void main(String[] args) {

        List<Object> a = new ArrayList<>();

        a.add("K");
        a.add(1);
        System.out.println(a);

        List<?> b = new ArrayList<>();

    }
}
