package _0practice.vi.genrics;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

public class ExtendingGenericClass {

    static class MyGeneric<T, E> {
        public MyGeneric() {
            System.out.println(
                    Arrays.toString(
                            MyGeneric.class.getTypeParameters()
                    )
            );
            System.out.println(
                    Arrays.toString(
                            ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()
                    )
            );
        }
    }
    static class Extend1<T, E> extends MyGeneric<T, E> {}
    static class Extend2<T, E> extends MyGeneric<String, Object> {}

    public static void main(String[] args) {
        Extend1<String, Integer> e1 = new Extend1<>();
        System.out.println(" ==================== ");
        Extend2 e2 = new Extend2();
    }

}
