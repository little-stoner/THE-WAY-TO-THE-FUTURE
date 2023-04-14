package _generics.faq;

import java.util.ArrayList;

public class TypeErasure {

    public static void main(String[] args) {
        System.out.println(new ArrayList<Integer>().getClass());
        System.out.println(new ArrayList().getClass());
    }

}
