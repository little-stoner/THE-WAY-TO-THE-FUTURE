package _onjava8._interfaces.interfaceprocessor;

public class Applicator {

    public static void apply(Processor p, Object s) {
        System.out.println(" Using Processor " + p.name());
        System.out.println(p.process(s));
    }
    public static void main(String[] args) {

    }
}
