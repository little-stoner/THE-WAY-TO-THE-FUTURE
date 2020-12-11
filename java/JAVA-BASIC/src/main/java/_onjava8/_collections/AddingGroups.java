package _onjava8._collections;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection =
                new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Integer[] moreInts = { 6, 7, 8, 8, 10 };
        collection.addAll(Arrays.asList(moreInts));

        Collections.addAll(collection, 11, 12);
        Collections.addAll(collection, moreInts);
        List<Integer> list = Arrays.asList(16, 17);
        list.set(1, 99);
    }
}
