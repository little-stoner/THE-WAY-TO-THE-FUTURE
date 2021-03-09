package _0practice.vi.string;

public class XambiguousY {

    public void foo(Object o) {
        System.out.println("Object");
    }

//    public void foo(String s) {
//        System.out.println("String");
//    }
//
//    public void foo(Integer i) {
//        System.out.println("Integer");
//    }

    public void foo(Exception e) {
        System.out.println("Exception");
    }

    public void foo(NullPointerException e) {
        System.out.println("NullPointerException");
    }

    public static void main(String[] args) {
        // new XambiguousY().foo(null);
        new XambiguousY().foo(null);
    }

}
