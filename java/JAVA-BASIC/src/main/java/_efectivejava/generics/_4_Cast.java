package _efectivejava.generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class _4_Cast {

    void m1() {
        List<Date> list = new ArrayList<Date>();
        m2(list);
    }

    void m2(Object arg) {
        List<String> list = (List<String>) arg; // unchecked warning
        m3(list);
    }

    void m3(List<String> list) {
        String s = list.get(0);
    }

    public static void main(String[] args) {
        _4_Cast c = new _4_Cast();
        c.m1();
    }

    static class Twins<T> {
        public T fst, snd;
        public Twins(T s, T t) {
            fst = s;
            snd = t;
        }
    }
    static class Pairr<S, T> {
        private S fst;
        private T snd;
        public Pairr(S s, T t) {
            fst = s;
            snd = t;
        }
        public <U> Pairr(Twins<U> twins) {
            fst = (S) twins.fst;
            snd = (T) twins.snd;
        }
    }

}
