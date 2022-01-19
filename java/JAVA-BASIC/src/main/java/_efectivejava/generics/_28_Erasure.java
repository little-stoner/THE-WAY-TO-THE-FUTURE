package _efectivejava.generics;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class _28_Erasure {

    interface Comparable<A> {
        public int compareTo(A that);
    }

    static final class NumericValue implements Comparable<NumericValue> {
        private byte value;

        public NumericValue(byte value) {
            this.value = value;
        }

        public byte getValue() {
            return value;
        }

        @Override
        public int compareTo(NumericValue that) {
            return this.value - that.value;
        }
    }

    static class Collections {
        public static <A extends Comparable<A>> A max(Collection<A> xs) {
            Iterator<A> xi = xs.iterator();
            A w = xi.next();
            while (xi.hasNext()) {
                A x = xi.next();
                if (w.compareTo(x) < 0) {
                    w = x;
                }
            }
            return w;
        }
    }

    final static class Test {
        public static void main(String[] args) {
            LinkedList<NumericValue> numberList = new LinkedList<NumericValue>();
            numberList.add(new NumericValue((byte) 0));
            numberList.add(new NumericValue((byte) 1));
            NumericValue y = Collections.max(numberList);
        }
    }

    ///////
    interface Comparable0 {
        public int compareTo(Object that);
    }
    static final class NumericValue0 implements Comparable0 {
        private byte value;
        public NumericValue0(byte value) { this.value = value; }
        public byte getValue() { return value; }
        public int compareTo(NumericValue that) { return this.value - that.value; }
        @Override
        public int compareTo(Object that) { return this.compareTo((NumericValue0)that); }
    }
    static class Collections0 {
        public static Comparable max(Collection xs) { Iterator xi = xs.iterator();
            Comparable w = (Comparable) xi.next(); while (xi.hasNext()) {
                Comparable x = (Comparable) xi.next();
                if (w.compareTo(x) < 0) w = x; }
            return w; }
    }
    static final class Test0 {
        public static void main (String[ ] args) {
            LinkedList numberList = new LinkedList();
            numberList.add(new NumericValue((byte)0));
            numberList.add(new NumericValue((byte)1));
            NumericValue y = (NumericValue) Collections.max(numberList);
        } }

}
