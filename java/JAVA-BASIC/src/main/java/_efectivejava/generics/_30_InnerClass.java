package _efectivejava.generics;

import java.util.concurrent.Executor;

public class _30_InnerClass {

    static class Sequence<E> {
        private E[] theSequence;
        private int idx;
        public static class NoMoreElementException extends Exception {}
        public static class NoElementException extends Exception {}
        public class Iterator {
            boolean hasNext() {
                return (theSequence != null && idx < theSequence.length);
            }
            E getNext() throws
                    NoElementException,
                    NoMoreElementException,
                    java.lang.IllegalStateException
            {
                if (theSequence == null) {
                    throw new NoElementException();
                }
                if (idx < 0) {
                    throw new IllegalStateException();
                }
                if (idx >= theSequence.length) {
                    throw new NoMoreElementException();
                } else {
                    return theSequence[idx++];
                }
            }
        }
        public Iterator getIterator() {
            return this.new Iterator();
        }
    }

    private static <T> void print(Sequence<T> seq) throws Exception {
        Sequence<T>.Iterator iter =  seq.new Iterator();
        while (iter.hasNext()) {
            System.out.println(iter.getNext());
        }
    }

    static class Controller<E extends Executor> {
        private E executor;
        public Controller(E e) { executor = e; }
        public interface Command {
            void doIt(Runnable task);
        }
        public Command command() { return task -> executor.execute(task);
        }
    }

    public static void main(String[] args) {
        try {
            Sequence<String> s1 = new Sequence<>();
            print(s1);
            Sequence<Long> s2 = new Sequence<>();
            print(s2);
        } catch (Exception e) {

        }
    }

}
