package _generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
    public static void main(String[] args) {
        // wildcards allow covariance
        List<? extends Fruit> flist = new ArrayList<>();
        // compile error: can't add any type of object
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        flist.add(null);
        Fruit f = flist.get(0);
    }
}
