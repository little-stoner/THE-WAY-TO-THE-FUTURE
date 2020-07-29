package _efectivejava.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Covariant {

    // Arrays Are Covariant
    public static void array() {
        // an array of type T[] may contain elements of type T
        //  or any subtype of T.
        Number[] numbers = new Number[3];
        numbers[0] = new Integer(10);
        numbers[1] = new Double(2.10);
        // numbers[2] = new Byte(0);
        System.out.println(Arrays.toString(numbers));

        System.out.println("======================");

        // subtyping rules in java
        // an array S[] is a subtype of the arrayT[]
        // if S is a subtype of T

        Integer[] mInts = { 1, 2, 3 };
        Number[] mNums = mInts;
        System.out.println(Arrays.toString(mNums));
//        mNums[0] = 2.13;
        System.out.println(Arrays.toString(mNums));

        System.out.println("=====================");

        // PECS
        List<? extends Number> numbers1 = new ArrayList<Integer>();
        List<? extends Number> numbers2 = new ArrayList<Float>();
        List<? extends Number> numbers3 = new ArrayList<Double>();

        List<? super Integer> n1 = new ArrayList<Number>();
        List<? super Float> n2 = new ArrayList<Number>();

    }

    // PECS (Produce extends Consume super)
    public static void copy(List<? extends Number> source,
                     List<? super Number> dest) {
        for (Number number : source) {
            dest.add(number);
        }
        System.out.println(dest);
    }

    private static class Box<T> {
        final T x;
        Box(T x) {
            this.x = x;
        }
    }

    public static void main(String[] args) {

        array();

        List<Integer> a = List.of(1, 2, 3);
        List<Double> b = List.of(3.14, 2.12);
        List<Object> c = new ArrayList<>();

        copy(a, c);
        copy(b, c);

        //
        // Box<String>[] bsa = new Box<String>[3];
        Object[] oa;

    }
}
