package _efectivejava.generics;

import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class _8_Wildcard {

    static class Box<T> {
        private T t;
        public Box(T t) { this.t = t; }
        public void put(T t) { this.t = t;}
        public T take() { return t; }
        public boolean equalTo(Box<T> other) { return this.t.equals(other.t); }
        public Box<T> copy() { return new Box<T>(t); }
        public void reset(T t) { this.t = t; }
    }

    class Box0<T> {
        private T t;
        public Box0(T t) { this.t = t; }
        public Box0(Box<? extends T> box) { t = box.t; }
        public boolean equalTo(Box<T> other) { return this.t.equals(other.t); }
        public Box<T> copy() { return new Box<T>(t); }
        public _1_HowToDeclareGenericType.Pair<T,T> makePair() { return new _1_HowToDeclareGenericType.Pair<T,T>(t,t); }
        public Class<T> getContentType() {
            return null;
        }
        public int compareTo(Comparable<? super T> other) { return other.compareTo(t); }
    }

    public static void main0(String[] args) throws ParseException {
        Collection<?> coll = new ArrayList<String>();
        List<? extends Number> list = new ArrayList<Long>();
        Comparator<? super String> cmp = new RuleBasedCollator("< a< b< c< d");
        _1_HowToDeclareGenericType.Pair<String, ?> pair = new _1_HowToDeclareGenericType.Pair<String, String>();
    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src) { // uses bounded wildcards
        for (int i=0; i<src.size(); i++) {
            dest.set(i,src.get(i));
        }
    }

    public static void main(String[] args) {
        Box<?> box = new Box<String>("abc");
        // box.put("xyz"); // error
        box.put(null); // ok
        // String s = box.take(); // error
        Object o = box.take(); // ok
        // boolean equal = box.equalTo(box); // error
        // equal = box.equalTo(new Box<String>("abc")); // error
        Box<?> box1 = box.copy(); // ok
        // Box<String> box2 = box.copy(); // error
    }

}