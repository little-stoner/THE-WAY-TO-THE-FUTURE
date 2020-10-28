
import java.util.*;


public class ValusVsReference {

    public static class Dog {
        private String name;
        private String color;
        public Dog(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public String getColor() { return this.color; }
        public void setColor(String color) { this.color = color; }
    }
    
    public static void test() {
        Dog samoye = new Dog("Timo");
        System.out.println(" dog color before fool: " + samoye.getColor());
        fool_around(samoye);
        System.out.println(" dog color after fool: " + samoye.getColor());
    }

    public static void test1() {
        Dog samoye = new Dog("Timo");
        System.out.println(" dog color before fool: " + samoye.getColor());
        another_fool(samoye);
        System.out.println(" dog color after fool: " + samoye.getColor());
    }    

    public static void fool_around(Dog d) {
        System.out.println("========== fool ==============");
        System.out.println(" dog name: " + d.getName());
        d.setColor("Black");
        System.out.println("========= fool end ==============");
    }

    public static void another_fool(Dog d) {
        System.out.println("========== another fool ==============");
        d = new Dog("haqi");
        System.out.println("========== fool end ==============");
    }
    
    public static void main(String[] args) {
        System.out.println("========= test0 ==============");                
        test();
        System.out.println();
        System.out.println("========= test1 ==============");        
        test1();
    }
    
}
