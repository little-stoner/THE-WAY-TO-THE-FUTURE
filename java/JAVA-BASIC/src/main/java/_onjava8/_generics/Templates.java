package _onjava8._generics;

public class Templates {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
    }
}

class Manipulator<T> {
    private T obj;
    Manipulator(T x) { obj = x; }
    public void manipulate() {
        // obj.f();                java only knows its a object
        obj.toString();
    }
}

// we give the T a bound
// the compiler will know

class Manipulator2<T extends HasF> {
    private T obj;
    Manipulator2(T x) { obj = x; }
    public void manipulate() { obj.f(); }
}

class Manipulator3 {
    private HasF obj;
    Manipulator3(HasF x) { obj = x; }
    public void manipulate() { obj.f(); }
}