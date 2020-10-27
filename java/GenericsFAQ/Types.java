import java.util.*;


public class Types {

    // generic type and parameterized type ???
    static class T<E> {
        E e;
        public T(E e) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(e);            
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");            
        }
        // private T<String> t = new T<>();
    }
    // define generic types
    static class Pair<X, Y> {
        private X first;
        private Y second;
        public Pair(X a1, Y a2) {
            first = a1;
            second = a2;
        }
        public X getFirst() { return first; }
        public void setFirst(X arg) { first = arg; }
        public Y getSecond() { return second; }
        public void setSecond(Y arg) { second = arg; }
        public String toString() {
            return "<Pair" + "(" + first + ", " + second + ")" + ">";
        }

        public void printPair(Pair<String, Long> pair) {
            System.out.println("(" + pair.getFirst() + ", " + pair.getSecond() + ")");
        }
        // public void printPair(Pair<?, ?> pair) {
        //     System.out.println("(" + pair.getFirst() +","+pair.getSecond()+")");
        // }
    }
    // anonymous inner class with generics
    public static T t() {
        new T<String>("A") {};
        new T<Integer>(1) {};
        return new T<Pair<String, String>>(new Pair<String, String>("a", "b")){
            public void h() {}
        };
    }
    // type erasure
    public static void type_erasure() {
        System.out.println(" runtime type of ArrayList<String>: " + new ArrayList<String>().getClass());
        System.out.println(" runtime type of ArrayList<Integer>: " + new ArrayList<Integer>().getClass());
    }
    // cast to a parameterized type
    public static void cast_to_parameterized_type() {
        System.out.println(" !!runtime detection::::: ");
        // downcast
        // cast happends to raw type
        //List<String> b = (List<String>) new Object();  // runtime check, which maybe raise a ClassCastException unanticipated !!
        System.out.println("==================================");
        System.out.println(" !!compile detection::::: ");
        // List<String> a = (List<String>) new ArrayList<Integer>();  // compile detection
        // upcast will not lead to an "unchecked" warning.
        List a = (List<String>) new ArrayList<String>() {{add("A--A");}};
        List b = (List<Object>) new ArrayList<Object>();
        System.out.println(a.getClass().getSimpleName());        
        System.out.println("==> " + a.get(0));
        System.out.println("==> " + a.get(0).getClass());        
        System.out.println("==================================");
    }
    // exceptin handle
    // static class X<T> extends Exception {} // generic class may not extend java.lang.Throwable

    // generic static member

    // List<Object> && List<String>
    public static void printAll(ArrayList<Object> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }
    public static void printAll(Collection<Object> c) {
        for (Object o : c) {
            System.out.println(o);
        }
    }
    public static void supertype_relation() {
        ArrayList<String> list = new ArrayList<String>();
        //printAll(list);  // error: no suitable method found  for printAll(ArrayList<String>)
        List<Object> list0 = new ArrayList<Object>();
        list0.add("QQQ");
        printAll(list0); // fine
    }
    // array of generic
    public static void generics_array() {
        // Pair<Integer, Integer>[] intPairArr = new Pair<Integer, Integer>[10]; // error: generic array creation
        Pair<Integer, Integer>[] intPairArr = new Pair[10];
        Object[] objArr = intPairArr;
        objArr[0] = new Pair<String, String>("", ""); // should fail, but would succeed
        Integer i = intPairArr[0].getFirst(); // fails at runtime with ClassCashException
    }
    
    //// workaround
    public static void generic_workaround() {
        // Pair<Integer, Integer>[] intPairArr = new Pair<Integer, Integer>[10]; // error
        // Pair<Integer, Integer>[] intPairArr = new Pair[10];
        // Pair[] intPairArr = new Pair[10];
        Pair<?,?>[] intPairArr = new Pair<?,?>[10];
        addElements(intPairArr);
        Pair<Integer, Integer> pair = intPairArr[1]; // error
        Integer i = pair.getFirst();
        pair.setSecond(i);
    }
    public static void addElements(Object[] objArr) {
        objArr[0] = new Pair<Integer, Integer>(0, 0);
        objArr[1] = new Pair<String, String>("", ""); // should fail with ArrayStoreException
    }
    //

    public static void main(String[] args) {
        
        System.out.println("anonymous inner class with generics: ");
        t();
        System.out.println("==================================");
        System.out.println("type erasure, runtime share the same bytecode: ");
        type_erasure();
        System.out.println("==================================");
        System.out.println("cast parameterized type: ");
        cast_to_parameterized_type();
        System.out.println("==================================");
        supertype_relation();
        System.out.println("==================================");        
        generic_workaround();
        System.out.println("==================================");          
        
    }
    
}
