package _efectivejava.generics;

import java.lang.reflect.*;
import java.util.*;

public class _26_Reflect {

    static class SomeClass<T> {
        static List<String> field = new ArrayList<String>();
        Set<? extends Number> f0 = new TreeSet<Long>();
        T f1;
        Iterable<?>[] f2;
        T[] f3;
    }

    static void printInfo(Field... fields) {
        for (Field f : fields) {
            System.out.println("===================================================");
            System.out.println(">>>>>>>>>>>>>>> generic type: " + f.getGenericType());
            System.out.println(">>>>>>>>>>>>>>> type: " + f.getType());
            System.out.println("===================================================");
        }
    }

    static void getClz() {
        Object tmp = java.util.EnumSet.allOf(java.util.concurrent.TimeUnit.class);
        Class<?> clazz = tmp.getClass();
        System.out.println("actual type of Object tmp is: " + clazz);
    }


    void analyzeType(Type type) {
        if (type instanceof Class) {
// regular type, e.g. String or Date[]
        } else if (type instanceof ParameterizedType) {
// parameteriezd type, e.g. List<String> or Set<? extends Number>
        } else if (type instanceof TypeVariable) {
// type variable, e.g. T
        } else if (type instanceof GenericArrayType) {
// generic array, e.g. List<?>[] or T[]
        } else if (type instanceof WildcardType) {
// wildcard, e.g. ? extends Number or ? super Long
        } else {
// we should never get here
            throw new InternalError("unknown type representation " + type);
        }
    }

    static void genericMethod() throws NoSuchMethodException {
        Method method = Collection.class.getMethod("toArray",Object[].class);
        System.out.println("METHOD: "+method.toGenericString());
    }

    static void method() throws Exception {
        Method theMethod = Collections.class.getMethod("max",Collection.class);
        System.out.println("analyzing method: ");
        System.out.println(theMethod.toGenericString()+"\n");
        TypeVariable[] typeParams = theMethod.getTypeParameters();
        if (typeParams!=null && typeParams.length>0) {
            System.out.println("GENERIC METHOD");
            System.out.println("type parameters: ");
            for (TypeVariable v : typeParams) {
                System.out.println("\t"+v);
            }
        } else {
            System.out.println("NON-GENERIC METHOD");
        }
        System.out.println();
        Type type = theMethod.getGenericReturnType();
        System.out.println("generic return type of method "+theMethod.getName()+": " + type);
        System.out.println();
        Type[] genParamTypes = theMethod.getGenericParameterTypes();
        if (genParamTypes == null || genParamTypes.length == 0) {
            System.out.println("no parameters"); } else {
            System.out.println("generic parameter types: "); for (Type t : genParamTypes) {
                System.out.println("\t"+t);
            }
        }
        System.out.println();
        Type[] genExcTypes = theMethod.getGenericExceptionTypes();
        if (genExcTypes == null || genExcTypes.length == 0) {
            System.out.println("no exceptions"); } else {
            System.out.println("generic exception types: ");
            for (Type t : genExcTypes) {
                System.out.println("\t"+t);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Field f = SomeClass.class.getDeclaredField("field");
        Field f0 = SomeClass.class.getDeclaredField("f0");
        Field f1 = SomeClass.class.getDeclaredField("f1");
        Field f2 = SomeClass.class.getDeclaredField("f2");
        Field f3 = SomeClass.class.getDeclaredField("f3");
        printInfo(f, f0, f1, f2, f3);
        getClz();
        genericMethod();
    }


}
