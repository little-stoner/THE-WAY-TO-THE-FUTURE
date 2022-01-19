package _efectivejava.chapter3.item13;

public class A implements Cloneable {

    public A() {
    }
    public A(String a) {
        System.out.println(">>>>>>>>>>>>>");
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A();
        System.out.println(a.clone());
    }
}
