package _efectivejava.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _20_Varargs {

    static <E> void addAll(List<E> list, E... array) {
        list.addAll(Arrays.asList(array));
    }

    public static <E> void addAll0(List<E> list, E[] array) {
        for (E element : array) {
            list.add(element);
        }
    }

    public static void main(String[] args) {
        addAll(new ArrayList<String>(),
                "Leonardo da Vinci",
                "Vasco de Gama"
        );
        addAll(new ArrayList<_1_HowToDeclareGenericType.Pair<String, String>>(), // unchecked warning
                new _1_HowToDeclareGenericType.Pair<String, String>("Leonardo", "da Vinci"),
                new _1_HowToDeclareGenericType.Pair<String, String>("Vasco", "de Gama")
        );
    }

}