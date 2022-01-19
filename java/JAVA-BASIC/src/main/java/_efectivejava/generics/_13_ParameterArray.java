package _efectivejava.generics;

import java.lang.reflect.Array;

public class _13_ParameterArray {

    static class Sequence<T> {
        public T[] asArray(Class<T> type) {
            T[] array = (T[]) Array.newInstance(type, 10);
            return array;
        }
    }

}
