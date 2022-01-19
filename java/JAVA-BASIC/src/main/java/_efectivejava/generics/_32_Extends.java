package _efectivejava.generics;

public class _32_Extends {

    static class Generic<T, E> {

    }
    static class Ext<T, E> extends Generic<T, E> {

    }
    static class Extt extends Generic<String, Object> {

    }
//    static class Exttt extends Generic<T, E> {
//
//    }

    static class Super<T> {
        public void set(T arg) {}
        public T get() { return null; }
    }
    static class Sub extends Super<Number> {
        @Override
        public void set(Number arg) {
            super.set(arg);
        }

        @Override
        public Number get() {
            return super.get();
        }
    }
    static class S<S> extends Super<S> {
        @Override
        public void set(S arg) {
            super.set(arg);
        }

        @Override
        public S get() {
            return super.get();
        }
    }
    static class SS<A, B> extends Super<A> {
        @Override
        public void set(A arg) {
            super.set(arg);
        }

        @Override
        public A get() {
            return super.get();
        }
    }

    static class SSS<N extends Number> extends Super<N> {
        @Override
        public void set(N arg) {
            super.set(arg);
        }

        @Override
        public N get() {
            return super.get();
        }
    }

    static class SSSS<N extends Number> extends Super<Number> {
        public void set(N arg) {
            super.set(arg);
        }

        @Override
        public N get() {
            return null;
        }
    }

}
