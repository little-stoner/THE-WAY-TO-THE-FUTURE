package _onjava8._interfaces;

public class  AnImplementation implements AnInterface {

    @Override
    public void firstMethod() {

    }

    @Override
    public void secondMethod() {

    }

    public static void main(String[] args) {
        AnInterface i = new AnImplementation();
        i.firstMethod();
        i.secondMethod();
    }
}
