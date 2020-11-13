import java.time.LocalDate;
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
        System.out.println("=================");

        Long approvedAt = 1603857600000L;
        Long current = System.currentTimeMillis();
        Long offset = current - approvedAt;

        System.out.println(" ========> " + offset);
        System.out.println(" =======> " + (offset / 1000 / 60 / 60 / 24));
        System.out.println(" =======> " + (Math.floorDiv(offset, 1000 * 60 * 60 * 24)));
        System.out.println(" =======> " + (Math.floor(offset / 1000 / 60 / 60 / 24)));

        System.out.println("========<><>><<<<<<<<<<<<=========");

        LocalDate now = LocalDate.now();
        System.out.println("==> " + now.getDayOfWeek());

        
        
        
    }


    
}
