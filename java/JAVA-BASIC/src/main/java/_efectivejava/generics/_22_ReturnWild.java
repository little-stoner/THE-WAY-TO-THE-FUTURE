package _efectivejava.generics;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class _22_ReturnWild {

    public static class WeakDateReference<T extends Date> extends WeakReference<T> {
        long time;

        public WeakDateReference(T t) {
            super(t);
            time = t.getTime();
        }

        public WeakDateReference(T t, ReferenceQueue<? super T> q) {
            super(t, q);
            time = t.getTime();
        }

        public long getCachedTime() {
            return time;
        }

        public boolean isEquivalentTo(WeakDateReference<T> other) {
            return this.time == other.getCachedTime();
        }

        public boolean contains(T t) {
            return this.get() == t;
        }

        public static void main(String[] args) {
            ReferenceQueue<Date> queue = new ReferenceQueue<Date>();
            Date date = new Date();
            WeakDateReference<Date> dateRef = new WeakDateReference<Date>(date, queue);
            // WeakDateReference<Date> deadRef = queue.poll();
            Reference<? extends Date> deadRef0 = queue.poll();
        }
    }



}
