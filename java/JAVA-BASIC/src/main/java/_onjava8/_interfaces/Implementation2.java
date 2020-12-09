package _onjava8._interfaces;

public class Implementation2
implements InterfaceWithDefault {
    @Override
    public void firstMethod() {

    }

    @Override
    public void secondMethod() {

    }

    public static void main(String[] args) {
        InterfaceWithDefault i = new Implementation2();
        i.firstMethod();
        i.secondMethod();
        i.newMethod();
    }
}
