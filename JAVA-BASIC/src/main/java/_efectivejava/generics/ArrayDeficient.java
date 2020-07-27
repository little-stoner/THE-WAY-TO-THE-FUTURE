package _efectivejava.generics;

import java.util.ArrayList;
import java.util.List;

public class ArrayDeficient<E extends Object> {


    public void f() {
        // E[] e = new E[10];
    }

    public static void main(String[] args) {

        Object[] objectArray = new Long[1];

        objectArray[0] = "AAA";               // throw ArrayStoreException

        System.out.println(objectArray);

        //=================================================================

        // List<Object> ol = new ArrayList<Long>();
        List<Object> ol = new ArrayList<>();
        ol.add("AAAAA");




    }

}
