package _onjava8._housekeeping;


class Window {
    Window(int marker){
        System.out.println("Window(" + marker + ")");
    }
}
class House {
    Window w1 = new Window(1); // before constructor
    House() {
        System.out.println("House()");
        w3 = new Window(3);
    }
    Window w2 = new Window(2);
    void f() {
        System.out.println(" f() ");
    }
    Window w3 = new Window(3);

    {
        System.out.println("=============");
    }
    static {
        System.out.println(">>>>>>>>>>>>>>>");
    }
    static Window w5 = new Window(5);
}

public class OrderOfInitialization {

    public static void main(String[] args) {
        House h = new House();
        h.f(); // shows that construction is done
    }

}
