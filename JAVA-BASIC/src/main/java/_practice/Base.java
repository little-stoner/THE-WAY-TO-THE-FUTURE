package _practice;

public class Base {

    static {
        System.out.println("I am Base");
    }

    {
        System.out.println("instance Base");
    }

    public Base() {}
    public Base(int i) {
        System.out.println(">>>>>>>>>>>> " + i);
    }

}
