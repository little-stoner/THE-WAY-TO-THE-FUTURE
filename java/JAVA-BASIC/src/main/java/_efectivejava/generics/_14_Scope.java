package _efectivejava.generics;

import java.util.Comparator;

public class _14_Scope {

    static class SomeClass<T> {
        static {
            // SomeClass<T> test = new SomeClass<>(); // error
        }

        // private static T globalInfo; // error
        // public static T getGlobalInfo() { // error
        //    return globalInfo;
        // }
        {
            SomeClass<T> test = new SomeClass<>();
        }

        private T localInfo;

        public T getLocalInfo() {
            return localInfo;
        }

        //
        public static class Failure extends Exception {
            // private final T info; // error

            // public Failure(T t) {
            //     info = t;
            // } // error

            // public T getInfo() {
            //     return info;
            // } // error
        }

        private interface Copyable {
            // T copy(); // error
        }

        private enum State {
            VALID, INVALID
            ;
            // private T info; // error
            // public void setInfo(T t) { info = t; } // error
            // public T getInfo() { return info; } // error
        }

        public class Accessor {
            public T getInfo() {
                return localInfo;
            }
        }

    }

    interface SomeInterface<T> { // field
        // SomeClass<T> value = new SomeClass<T>(); // error
        // nested type
        // class Accessor {
        //    public T getInfo() {
        //         return value.getGlobalInfo();
        //     }
        // }
        // methods
        T getValue();
    }

    private interface Copyablee<T> {
        T copy();
    }
    <T extends Copyablee<T>> void nonStaticMethod(T t) {
        final T copy = t.copy();
        class Task implements Runnable {
            @Override
            public void run() {
                T tmp = copy;
                System.out.println(tmp);
            }
        }
        (new Task()).run();
    }
    static <T extends Copyablee<T>> void staticMethod(T t) {
        final T copy = t.copy();
        class Task implements Runnable {
            @Override
            public void run() {
                T tmp = copy;
                System.out.println(tmp);
            }
        }
        (new Task()).run();
    }

    public static final class Wrapper<T> {
        protected final T theObject;
        public Wrapper(T t) { theObject = t; } public T getWrapper() { return theObject; }
        private final class WrapperComparator<W extends Wrapper<? extends Comparable<T>>>
                implements Comparator<W> {
            @Override
            public int compare(W lhs, W rhs) {
                return lhs.theObject.compareTo((T)(rhs.theObject));
            }
        }
        public <V extends Wrapper<? extends Comparable<T>>> Comparator<V> comparator() {
            return this.new WrapperComparator<V>();
        }
    }

}
