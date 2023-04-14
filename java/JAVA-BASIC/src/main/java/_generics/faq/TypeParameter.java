package _generics.faq;


import java.util.SortedSet;

public class TypeParameter {

    interface Type<T> {
    }

    interface TypeKey<Key extends Comparable<Key>> {
    }

    interface TypeBound<Bound extends Cloneable & Comparable<Bound>> {
    }

}