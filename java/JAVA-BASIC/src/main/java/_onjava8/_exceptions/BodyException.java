package _onjava8._exceptions;

class Third extends Reporter {
}

public class BodyException {
    public static void main(String[] args) {
        try (
                First f = new First();
                Second s2 = new Second()
        ) {
            System.out.println(" In Body ");
            Third t = new Third();
            new SecondException();
            System.out.println(" End of body ");
        } catch (CE E) {
            System.out.println(" Caught: " + E);
        }
    }
}
