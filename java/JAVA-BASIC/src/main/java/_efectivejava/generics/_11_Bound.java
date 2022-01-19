package _efectivejava.generics;

import java.util.*;

public class _11_Bound {

    public class Hashtable<Key, Data> {
        private class Entry<Key, Data> {
            private Key key;
            private Data value;
            private int hash;
            private Entry<Key, Data> next;
        }

        private Entry<Key, Data>[] table;

        public Data get(Key key) {
            int hash = key.hashCode();
            int hashMask = 0x00;
            for (Entry<Key, Data> e = table[hash & hashMask]; e != null; e = e.next) {
                if ((e.hash == hash) && e.key.equals(key)) {
                    return e.value;
                }
            }
            return null;
        }
    }

    public interface Comparable<T> {
        public int compareTo(T arg);
    }

    public class TreeMap<Key extends Comparable<? super Key>, Data> {
        private class Entry<K, V> {
            K key;
            V value;
            Entry<K, V> left = null;
            Entry<K, V> right = null;
            Entry<K, V> parent;
        }

        private transient Entry<Key, Data> root = null;

        private Entry<Key, Data> getEntry(Key key) {
            Entry<Key, Data> p = root;
            Key k = key;
            while (p != null) {
                int cmp = k.compareTo(p.key);
                if (cmp == 0)
                    return p;
                else if (cmp < 0)
                    p = p.left;
                else
                    p = p.right;
            }
            return null;
        }

        public boolean containsKey(Key key) {
            return getEntry(key) != null;
        }
    }

    //
    static class X<T extends List<? extends Number>> {
        public void someMethod(T t) {
            // t.add(new Long(0L)); // error
            Number n = t.remove(0);
        }
    }

    public static void main(String[] args) {
        X<ArrayList<Long>> x1 = new X<ArrayList<Long>>();
        // X<ArrayList<String>> x2 = new X<ArrayList<String>>(); // error
    }

    //
    class Triple<T> {
        private T fst, snd, trd;

        public <U extends T, V extends T, W extends T> Triple(U arg1, V arg2, W arg3) {
            fst = arg1;
            snd = arg2;
            trd = arg3;
        }
    }

    // error
//    class ObjectStore<T extends Comparable<T> & Comparable<String>> {
//        private Set<T> theObjects = new TreeSet<T>();
//
//        public boolean equals(ObjectStore<String> other) {
//            if (theObjects.size() != other.size()) return false;
//            Iterator<T> iterThis = theObjects.iterator();
//            Iterator<String> iterOther = other.theObjects.iterator();
//            while (iterThis.hasNext() && iterOther.hasNext()) {
//                T t = iterThis.next();
//                String string = iterOther.next();
//                if (t.compareTo(string) != 0) return false;
//            }
//            return true;
//        }
//    }

    public static class SuperClass {
        // static members
        public enum EnumType {THIS, THAT}

        public static Object staticField;

        public static Object staticMethod() {
            return null;
        }

        // non-static members
        public class InnerClass {
        }

        public Object nonStaticField;

        public Object nonStaticMethod() {
            return null;
        }

        // constructors
        public SuperClass() {
        }

        // private members
        private Object privateField;
    }

    public final static class SomeClass<T extends SuperClass> {
        private T object;

        public SomeClass(T t) {
            object = t;
        }

        public String toString() {
            return
                    "static nested type : " + T.EnumType.class + " \n"
                            + "static field : " + T.staticField + "\n"
                            + "static method: " + T.staticMethod() + "\n"
                            + "non-static nested type: " + T.InnerClass.class + "\n"
                            + "non-static field : " + object.nonStaticField + "\n"
                            + "non-static method : " + object.nonStaticMethod() + "\n"
                    // + "constructor : " + (new T()) + "\n"                    // error
                    // + "private member : " + object.privateField + "\n"       // error
                    ;


        }
    }
    public final static class SubClass extends SuperClass {
        // static members
        public enum Type {FIX, FOXI}

        public static Object staticField;

        public static Object staticMethod() {
            return null;
        }

        // non-static members
        public class Inner {
        }

        public Object nonStaticField;

        public Object nonStaticMethod() {
            return null;
        }

        // constructors
        public SubClass(Object o) {
        }

        public SubClass(String s) {
        }

        public static void main(String[] args) {

            SomeClass<SubClass> ref = new SomeClass<SubClass>(new SubClass("xxx"));
            System.out.println(ref);
        }

    }

    static class Person implements Comparable<Person> {
        @Override
        public int compareTo(Person arg) {
            return 0;
        }
    }
    static class Student extends Person {
        public static void main(String[] args) {
           Comparable c = (Comparable) new Student();
        }
    }

}
