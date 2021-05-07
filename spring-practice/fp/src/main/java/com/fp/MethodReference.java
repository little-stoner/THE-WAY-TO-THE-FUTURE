package com.fp;

import java.util.stream.Stream;

public class MethodReference {

    interface DB {
        void execute(Object o);
    }
    interface LK {
        void send(Integer s);
    }
    static class DBImpl implements DB {
        @Override
        public void execute(Object o) {
            System.out.println(" DB: execute ");
        }
    }
    static class LKImpl implements LK {
        @Override
        public void send(Integer s) {
            System.out.println(" LK: send ");
        }
    }

    public static void main(String[] args) {
        DB db = new DBImpl();
        Stream.of(1, 2).forEach(db::execute);
        LK lk = new LKImpl();
        Stream.of(2, 3).forEach(lk::send);
    }

}
