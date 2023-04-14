package _generics.faq;

import java.util.ArrayList;
import java.util.List;

public class TypeCast {

    void m1() {
        List<Integer> list = new ArrayList<>();
        m2(list);
    }

    void m2(Object arg) {
        List<String> list = (List<String>) arg;
        m3(list);
    }

    void m3(List<String> list) {
        String s = list.get(0);
    }

    public static void main(String[] args) {
        try {

        } catch (Exception e) {

        }
    }

}
