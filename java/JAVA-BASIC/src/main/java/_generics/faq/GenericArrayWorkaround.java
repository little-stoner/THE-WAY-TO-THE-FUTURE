package _generics.faq;

import _generics.faq.entity.Pair;

import java.util.ArrayList;
import java.util.List;

public class GenericArrayWorkaround {

    static void test() {
        Pair[] intPairArr = new Pair[10];
        addElements(intPairArr);
        Pair<Integer, Integer> pair = intPairArr[1];
        Integer i = pair.getFirst(); // fails with ClassClassException
        pair.setSecond(1);
    }

    static void addElements(Object[] objArr) {
        objArr[0] = new Pair<Integer, Integer>(0, 0);
        objArr[1] = new Pair<String, String>("", "");
    }

    static void test0() {
        Pair<?, ?>[] intPairArr = new Pair<?, ?>[10];
        addElements0(intPairArr);
        // Pair<Integer, Integer> pair = intPairArr[1]; // error
        // Integer i = pair.getFirst();
        // pair.setSecond(i);
    }
    static void addElements0(Object[] objArr) {
        objArr[0] = new Pair<Integer, Integer>(0, 0);
        objArr[1] = new Pair<String, String>("", "");
    }

    static void test1() {
        ArrayList<Pair<Integer, Integer>> intPairArr =
                new ArrayList<>(10);
        addElements1(intPairArr);
        Pair<Integer, Integer> pair = intPairArr.get(1);
        Integer i = pair.getFirst();
        pair.setSecond(i);
    }
    static void addElements1(List<?> objArr) {
        // objArr.add(0, new Pair<Integer, Integer>(0, 0));  // error
        // objArr.add(0, new Pair<String, String>("", "")); // error
    }

}
