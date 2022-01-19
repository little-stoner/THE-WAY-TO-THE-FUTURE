package _efectivejava.generics;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.ListIterator;

public class _21_Ttransform {

    <T> void fill(List<? super T> list, T obj) {

    }

    <S, T extends S> void fill0(List<S> list, T obj) {

    }

    public static <T> void fill9(List<? super T> list, T obj) {
        int size = list.size();
        ListIterator<? super T> itr = list.listIterator();
        for (int i = 0; i < size; i++) {
            itr.next();
            itr.set(obj);
        }
    }

    //
    public static <T> void reverse(List<T> list) {
        ListIterator<T> fwd = list.listIterator();
        ListIterator<T> rev = list.listIterator(list.size());
        for (int i = 0, mid = list.size() >> 1; i < mid; i++) {
            T tmp = fwd.next();
            fwd.set(rev.previous());
            rev.set(tmp);
        }
    }

    public static void reverse0(List<?> list) {
        ListIterator<?> fwd = list.listIterator();
        ListIterator<?> rev = list.listIterator(list.size());
        for (int i = 0, mid = list.size() >> 1; i < mid; i++) {
            Object tmp = fwd.next();
            // fwd.set(rev.previous()); // error
            // rev.set(tmp); // error
        }
    }
    public static <T>List<T> reverse1(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            tmp.set(i, list.get(list.size() - i - 1)); }
        return tmp;
    }

//    public static List<?> reverse(List<?> list) {
//        List<?> tmp = new ArrayList<?>(list); // error
//        for (int i = 0; i < list.size(); i++) {
//            tmp.set(i, list.get(list.size() - i - 1)); // error
//            return tmp;
//        }
//    }

    //
    //
    public static<T> void copy(List<? super T> dest, List<? extends T> src) {
        int srcSize = src.size();
        if (srcSize > dest.size()) {
            throw new IndexOutOfBoundsException("Source does not fit in dest");
        }
        ListIterator<? super T> di=dest.listIterator();
        ListIterator<? extends T> si=src.listIterator();
        for (int i = 0; i < srcSize; i++) {
            di.next();
            di.set(si.next());
        }
    }

    public static <U,T extends U,L extends T> void copy0(List<U> dest, List<L> src) {
        int srcSize = src.size();
        if (srcSize > dest.size()) {
            throw new IndexOutOfBoundsException("Source does not fit in dest");
        }
        ListIterator<U> di = dest.listIterator();
        ListIterator<L> si = src.listIterator();
        for (int i = 0; i < srcSize; i++) {
            di.next();
            di.set(si.next());
        }
    }

    ///
    public static <T> void print1(List<_8_Wildcard.Box<T>> list) {
        for (_8_Wildcard.Box<T> box : list) {
            System.out.println(box);
        }
    }
    public static void print2(List<_8_Wildcard.Box<?>> list) {
        for (_8_Wildcard.Box<?> box : list) {
            System.out.println(box);
        }
    }
    public static void print3(List<? extends _8_Wildcard.Box<?>> list) {
        for (_8_Wildcard.Box<?> box : list) {
            System.out.println(box);
        }
    }

    public static void main(String[] args) {
        List<_8_Wildcard.Box<?>> list1 = new ArrayList<_8_Wildcard.Box<?>>();
        list1.add(new _8_Wildcard.Box<String>("abc"));
        list1.add(new _8_Wildcard.Box<Integer>(100));
        // print1(list1); // error
        print2(list1); // fine
        print3(list1);
        List<_8_Wildcard.Box<Object>> list2 = new ArrayList<_8_Wildcard.Box<Object>>();
        list2.add(new _8_Wildcard.Box<Object>("abc"));
        list2.add(new _8_Wildcard.Box<Object>(100));
        print1(list2); // fine
        /// print2(list2);// error
        print3(list2);
    }

    //
    public interface State {
        boolean isIdle();
    }
    public static <T extends Enum<T> & State> boolean hasIdleState(EnumSet<T> set) {
        for (T state : set) {
            if (state.isIdle()) {
                return true;
            }
        }
        return false;
    }



}
