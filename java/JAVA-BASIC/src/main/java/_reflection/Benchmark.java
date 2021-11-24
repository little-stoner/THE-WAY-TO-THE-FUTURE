package _reflection;

import java.lang.reflect.InvocationTargetException;

public class Benchmark {

    private static int N = 20000000;

    public static class R {
        public void dosomething() {

        }
    }

    public static void regular() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            R r = new R();
            r.dosomething();
        }
        System.out.println("regular spend time: " + (System.currentTimeMillis() - start));
    }

    public static void reflect() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            R r = R.class.getDeclaredConstructor().newInstance();
            r.dosomething();
        }
        System.out.println("reflect spend time: " + (System.currentTimeMillis() - start));
    }

    public static void main(String[] args) throws Exception {
        regular();
        reflect();
    }

}
