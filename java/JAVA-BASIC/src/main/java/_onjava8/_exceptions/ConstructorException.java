package _onjava8._exceptions;

class CE extends Exception {}
class SecondException extends Reporter {
    SecondException() throws CE {
        super();
        throw new CE();
    }
}

public class ConstructorException {
    public static void main(String[] args) {
        try (
                First f = new First();
                SecondException s = new SecondException();
                Second s2 = new Second();
                ) {
            System.out.println(" In body ");
        }  catch (CE e) {
            System.out.println(" Caught: " + e);
        }
    }
}
