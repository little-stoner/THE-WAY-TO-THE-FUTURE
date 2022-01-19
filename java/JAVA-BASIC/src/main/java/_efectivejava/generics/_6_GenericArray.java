package _efectivejava.generics;

import java.util.ArrayList;
import java.util.List;

public class _6_GenericArray {

    static class Name extends _1_HowToDeclareGenericType.Pair<String, String> {
        private String first;
        private String second;

        public Name() {
        }

        public Name(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    void printArrayOfStringPairs(_1_HowToDeclareGenericType.Pair<String, String>[] pa) {
        for (_1_HowToDeclareGenericType.Pair<String, String> p : pa) {
            if (p != null) {
                System.out.println(p.getFirst() + " " + p.getSecond());
            }
        }
    }

    _1_HowToDeclareGenericType.Pair<String, String>[] createArrayOfStringPairs() {
        _1_HowToDeclareGenericType.Pair<String, String>[] arr = new Name[2];
        arr[0] = new Name("Angelika", "Langer"); // fine
        arr[1] = new _1_HowToDeclareGenericType.Pair<String, String>("a", "b"); // fine (causes ArrayStoreException)
        return arr;
    }

    void extractStringPairsFromArray(_1_HowToDeclareGenericType.Pair<String, String>[] arr) {
        Name name = (Name) arr[0]; // fine
        _1_HowToDeclareGenericType.Pair<String, String> p1 = arr[1]; // fine
    }

    void test() {
        _1_HowToDeclareGenericType.Pair<String, String>[] arr = createArrayOfStringPairs();
        printArrayOfStringPairs(arr);
        extractStringPairsFromArray(arr);
    }

    void printArrayOfStringPairs0(_1_HowToDeclareGenericType.Pair<String, String>[] pa) {
        for (_1_HowToDeclareGenericType.Pair<String, String> p : pa) {
            if (p != null) {
                System.out.println(p.getFirst() + " " + p.getSecond());
            }
        }
    }

    Name[] createArrayOfStringPairs0() {
        Name[] arr = new Name[2];
        arr[0] = new Name("Angelika", "Langer"); // fine
        // arr[1] = new _1_HowToDeclareGenericType.Pair<String,String>("a","b"); // error
        return arr;
    }

    void extractStringPairsFromArray0(Name[] arr) {
        Name name = arr[0]; // fine (needs no cast)
        _1_HowToDeclareGenericType.Pair<String, String> p1 = arr[1]; // fine
    }

    void test0() {
        Name[] arr = createArrayOfStringPairs0();
        printArrayOfStringPairs0(arr);
        extractStringPairsFromArray0(arr);
    }

    /**
     ==========================================================================================================
     = Workaround
     ==========================================================================================================
     */

    static void workaround() {
        _1_HowToDeclareGenericType.Pair[] intPairArr = new _1_HowToDeclareGenericType.Pair[10]; // error
        addElements(intPairArr);
        _1_HowToDeclareGenericType.Pair<Integer, Integer> pair = intPairArr[1];
        Integer i = pair.getFirst();  // fails with ClassCastException
        pair.setSecond(i);
    }

    static void workaround0() {
        _1_HowToDeclareGenericType.Pair<?,?>[] intPairArr = new _1_HowToDeclareGenericType.Pair<?,?>[10];
        addElements(intPairArr);
        // _1_HowToDeclareGenericType.Pair<Integer,Integer> pair = intPairArr[1]; // error
        // Integer i = pair.getFirst();
        // pair.setSecond(i);
    }

    static void workaround1() {
        ArrayList<_1_HowToDeclareGenericType.Pair<Integer,Integer>> intPairArr = new
            ArrayList<_1_HowToDeclareGenericType.Pair<Integer,Integer>>(10);
        addElements(intPairArr);
        _1_HowToDeclareGenericType.Pair<Integer,Integer> pair = intPairArr.get(1);
        Integer i = pair.getFirst();
        pair.setSecond(i);
    }

    static void addElements(Object[] objArr) {
        objArr[0] = new _1_HowToDeclareGenericType.Pair<Integer, Integer>(0, 0);
        objArr[1] = new _1_HowToDeclareGenericType.Pair<String, String>("", ""); // ArrayStoreException
    }

    static void addElements(List<?> objArr) {
        // objArr.add(0,new _1_HowToDeclareGenericType.Pair<Integer,Integer>(0,0)); // error
        // objArr.add(1,new _1_HowToDeclareGenericType.Pair<String,String>("","")); // error
    }

    public static void main(String[] args) {
        _6_GenericArray a = new _6_GenericArray();
        workaround();
    }

}
