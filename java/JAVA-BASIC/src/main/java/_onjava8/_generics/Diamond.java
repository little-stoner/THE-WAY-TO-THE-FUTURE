package _onjava8._generics;

class Bob {
}

public class Diamond {
    public static void main(String[] args) {
        GenericHolder<Bob> h3 = new GenericHolder<>();
        h3.set(new Bob());
    }
}
