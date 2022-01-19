package _efectivejava.generics;

import java.lang.reflect.Array;

public class _25_TypeInfo {

    public static <T> void someMethod(T dummy) { Class<?> type = dummy.getClass();

    }
    public static <T> void someMethod(T[] dummy) {

        Class<?> type = dummy.getClass().getComponentType();
    }
    public static <T> void someMethod(Class<T> type) throws IllegalAccessException, InstantiationException {
        T r = (T) type.newInstance();
        T[] rr = (T[]) Array.newInstance(type,90);
        type.isInstance("ref");
        type.cast("t");
    }

    public static <T> T[] createBuffer(Class<T> type) {
        return (T[])Array.newInstance(type,90);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] slice(T[] src, Class<T> type, int start, int length) {
        T[] result = (T[])Array.newInstance(type,length);
        System.arraycopy(src, start, result, 0, length);
        return result;
    }

}
