package _efectivejava.generics;

public class _31_MethodArgument {

    static class Utilities {
        public static <T> void fill(T[] array, T elem) {
            for (int i=0; i < array.length; i++) {
                array[i] = elem;
            }
        }
        public static <T, S extends T> void fill0(T[] array, S elem) {
            for (int i=0; i<array.length; ++i) {
                array[i] = elem;
            }
        }
    }

    public static void main(String[] args) {
        Utilities.fill(new String[5], new String("XYZ")); // T:=String
        Utilities.fill(new String[5], new Integer(100)); // T:=Object&Serializable&Comparable

        Utilities.fill0(new String[5], new String("XYZ")); // T:=Object&Serializable&Comparable and S:=String => fine
        Utilities.fill0(new String[5], new Integer(100)); // T:=Object&Serializable&Comparable and S:=String => fine
    }

}
