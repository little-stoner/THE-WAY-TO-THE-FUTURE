package _efectivejava.generics.item30;

import java.util.HashSet;
import java.util.Set;

public class Union {

    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<String> guys = Set.of("T", "D", "H");
        Set<String> stooges = Set.of("Lar", "Moe", "Cu");
        Set<String> afl = union(guys, stooges);
        System.out.println(afl);
    }

}
