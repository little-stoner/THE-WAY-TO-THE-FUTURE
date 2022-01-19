package _efectivejava.generics;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class _10_Method {

    public static <A extends Comparable<A>> A max(Collection<A> xs) {
        Iterator<A> xi = xs.iterator(); A w = xi.next();
        while (xi.hasNext()) {
            A x = xi.next();
            if (w.compareTo(x) < 0) {
                w = x;
            }
        }
        return w;
    }

    public static void main (String[ ] args) {
        LinkedList<Long> list = new LinkedList<Long>(); list.add(0L);
        list.add(1L);
        Long y = Collections.max(list);
    }

}
