package _generics;

import java.util.ArrayList;
import java.util.List;

public class ObjectGeneric {

    public static void main(String[] args) {
        List<Object> o = new ArrayList<>();
        o.add(1);
        o.add("a");
        System.out.println(o);
        List l = new ArrayList();
        l.add(1);
        l.add("a");
        System.out.println(l);
    }

}
