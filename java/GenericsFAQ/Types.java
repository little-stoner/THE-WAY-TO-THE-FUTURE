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
        List<String> b = (List<String>) new Object();  // runtime check, which will raise a ClassCastException
        System.out.println("==================================");
        System.out.println(" !!compile detection::::: ");
        // List<String> a = (List<String>) new ArrayList<Integer>();  // compile detection
        System.out.println("==================================");
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
        
    }
    
}
