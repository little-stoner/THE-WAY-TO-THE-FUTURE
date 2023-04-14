package _generics.faq.entity;

public class TypeCast {

    private static class Twins<T> {
        public T fst, snd;
        public Twins(T s, T t) { fst = s; snd = t; }
    }
    private static class Pair<S, T> {
        private S fst;
        private T snd;
        public Pair(S s, T t) { fst = s; snd = t; }
        public <U> Pair(Twins<U> twins) {
            fst = (S) twins.fst;
            snd = (T) twins.snd;
        }
    }

}
