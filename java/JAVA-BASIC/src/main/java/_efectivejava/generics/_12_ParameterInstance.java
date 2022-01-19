package _efectivejava.generics;

import java.lang.reflect.InvocationTargetException;

public class _12_ParameterInstance {

    static class P<A, B> {
        public final A fst;
        public final B snd;
        public P(Class<A> typeA, Class<B> typeB) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            this.fst = typeA.getDeclaredConstructor().newInstance();
            this.snd = typeB.getDeclaredConstructor().newInstance();
        }
        public P(A fst, B snd) {
            this.fst = fst;
            this.snd = snd;
        }
    }

}
