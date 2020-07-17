package _functional;

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}

public class FunctionalAnnotation {

    public String goodbye(String arg) {
        return "GoodBye, " + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::goodbye;
        FunctionalNoAnn fna = fa::goodbye;
        Functional fl  = a -> "Good bye,  " + a;
        FunctionalNoAnn fnal = a -> "Goodbye, " + a;
    }

}
