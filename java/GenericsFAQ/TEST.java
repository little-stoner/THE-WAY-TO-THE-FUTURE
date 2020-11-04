import java.util.*;


public class TEST {


    static class T<E> {
        E e;
        public T(E e) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(e);            
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>");            
        }
        // private T<String> t = new T<>();
    }
    //
    public static T t() {
        new T<String>("A") {};
        new T<Integer>(1) {};
        return new T<String>("a"){
            public void h() {}
        };
    }    
    
    public static void main(String[] args) {
        System.out.println("=================");
        t();   
    }


    
}
