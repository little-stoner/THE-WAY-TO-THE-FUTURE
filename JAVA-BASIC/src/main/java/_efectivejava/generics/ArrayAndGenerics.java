package _efectivejava.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAndGenerics<E> {


    public void t() {

        List[] a = new List[2];
        //List<E>[] b = new List<E>[1];

       // E[] c = new E[];

        // List<String>[] stringLists = new List<String>[1];
        List[] lists = new List[1];
        //List<Integer> intList = List.of(42);
        //Object[] objects = stringLists;
       // objects[0] = intList;
       // String s = stringLists[0].get(0);




    }

    public static void main(String[] args) {

        Number[] numbers = new Number[10];
        numbers[0] = Integer.valueOf(1);
        numbers[1] = Double.valueOf(1.0);

        System.out.println(numbers);

        Integer[] integers = { 1, 2, 3 };
        numbers = integers;

//        numbers[0] = 3.12;

        Object[] k = new Object[2];
        k[1] = "kkk";
        k[0] = 1;
        System.out.println(Arrays.toString(k));

        System.out.println(numbers);

        System.out.println("=======================================");

        List<?>[] c = new List<?>[1];
        c[0] = new ArrayList<>(2);
        System.out.println(Arrays.toString(c));

        System.out.println("=======================================");

        List<Integer> myInts = List.of(1,2,3,4);
        List<Double> myDoubles = List.of(3.14, 6.28);
        List<Object> myObjs = new ArrayList<>();
        List raw = new ArrayList();

        // Arrays.copyOf(myInts, myObjs);
        // Arrays.copyOf(myDoubles, myObjs);

        raw = myInts;
        raw = myDoubles;
        raw = myObjs;

        Object[] a = new Object[10];
        String[] b = (String[])a;

    }

}
