package _efectivejava.generics;

import java.util.ArrayList;

public class _9_Reifiable {

    public static void main(String[] args) {

        Object[] pairArr = new _1_HowToDeclareGenericType.Pair<?, ?>[10]; // fine
        pairArr[0] = new _1_HowToDeclareGenericType.Pair<Long, Long>(0L, 0L); // fine
        pairArr[0] = new _1_HowToDeclareGenericType.Pair<String, String>("", ""); // fine
        pairArr[0] = new ArrayList<String>(); // fails with ArrayStoreException

        //
        _1_HowToDeclareGenericType.Pair<?, ?>[] arr = new _1_HowToDeclareGenericType.Pair<?, ?>[10];

    }

}
