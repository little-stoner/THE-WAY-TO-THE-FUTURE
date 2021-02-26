package _efectivejava.generics;

import _0practice.vi.genrics.ExtendingGenericClass;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

public class Generic0<E> {

    private String o;

    public Generic0() {
        System.out.println(getClass().getTypeParameters()[0].getTypeName());
        System.out.println(getClass().getTypeParameters()[0].getGenericDeclaration());
        System.out.println(
                        Arrays.toString(
                                Generic0.class.getTypeParameters()
                        )
                );
        System.out.println(getClass().getGenericSuperclass());
//        System.out.println(
//                Arrays.toString(
//                        ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()
//                )
//        );

    }

    public static void main(String[] args) {
        Generic0<String> g = new Generic0<String>();
    }

}
