package _practice;

public class SubA extends Base {

    static {
        System.out.println(" I am SubA ");
    }

    {
        System.out.println("instance SubA");
    }

    public SubA() {}
    public SubA(int i) {
//        super(i);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@ " + i);
    }

    public void f() {
        System.out.println("#########################");
    }

    public static void main(String[] args) {
        new SubA(1).f();
    }

}
