package _efectivejava.generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class _23_WildArgs {

    ////////////////////////////////////////////////////

    public static void reverse(List<?> list) {
        rev(list);
    }

    private static <T> void rev(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            tmp.set(i, list.get(list.size() - i - 1));
        }
        list = tmp;
    }

    /////////////////////////////////////////////////////
    static class Pair<E> {
        private E fst, snd, third;

        public Pair() {
        }

        public Pair(E f, E s, E t) {
            fst = f;
            snd = s;
            third = t;
        }

        public E getFirst() {
            return fst;
        }

        public void setFirst(E s) {
            fst = s;
        }

        public E getSecond() {
            return snd;
        }

        public void setSecond(E snd) {
            this.snd = snd;
        }
    }

    public static <E, T extends Pair<E>> ArrayList<T> swapAndReverse0(ArrayList<T> l) {
        ArrayList<T> list = new ArrayList<T>(l);
        for (int i = 0; i < l.size(); i++) {
            list.set(i, l.get(l.size() - i - 1));
        }
        for (T pair : list) {
            E e = pair.getFirst();
            pair.setFirst(pair.getSecond());
            pair.setSecond(e);
        }
        return list;
    }

    public static ArrayList<? extends Pair<?>> swapAndReverse(ArrayList<? extends Pair<?>> l) {
        return capturePairType(l);
    }

    private static <T extends Pair<?>> ArrayList<T> capturePairType(ArrayList<T> l) {
        ArrayList<T> list = new ArrayList<T>(l);
        for (int i = 0; i < l.size(); i++) {
            list.set(i, l.get(l.size() - i - 1));
        }
        for (T pair : list) {
            captureMemberType((Pair<?>)pair);
        }
        return list;
    }

    private static <T extends Pair<?>> void captureMemberType0(T pair) {
    }

    private static <E> void captureMemberType(Pair<E> pair) {
        E e = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(e);
    }

    public static void main(String[] args) {
        ArrayList<Pair<Integer>> list = new ArrayList<Pair<Integer>>();
        list.add(new Pair<Integer>(-1, 1, 0));
        list.add(new Pair<Integer>(1, 0, 0));
        List<?> result = swapAndReverse(list);
        ArrayList<Pair<?>> list0 = new ArrayList<Pair<?>>();
        list0.add(new Pair<String>("a", "b", "c"));
        list0.add(new Pair<Integer>(1, 0, -1));
        list0.add(new Pair<Object>(new Date(), Thread.State.NEW, 5));

    }

    //

    interface Acceptor<V> {
        // void accept(Task<V> task, V v);
        void accept(Task<? extends V> task, V v);
    }
    interface Task<U> {
        void go(Acceptor<? super U> acceptor);
    }
    class AcceptingTask<U> implements Task<U> {
        @Override
        public void go(Acceptor<? super U> acceptor) {
            U result = null;
            acceptor.accept(this, result); // error
        }
    }


}
