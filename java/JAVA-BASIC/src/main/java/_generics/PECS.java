package _generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PECS {

    public static void main(String[] args) {
        List<? extends String> p = Arrays.asList("a", "b", "c");
        List<? super String> c = new ArrayList<>();
        for (String pp : p) {
            c.add(pp);
        }
        System.out.println(c);
    }

}
