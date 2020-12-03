package _onjava8._resue;

class SmallBrain {}

final class Dinosaur {
    int i = 7;
    int j = 1;
    SmallBrain x = new SmallBrain();
    void f()  {}
}

//class Further extends Dinosaur {
// Error: can not subclass final class
//}

public class Jurassic {

    public static void main(String[] args) {
        Dinosaur n = new Dinosaur();
        n.f();
        n.i = 40;
        n.j++;
    }
    
}
