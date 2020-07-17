package _typeinfo;

import java.util.stream.Stream;

class Cookie {
    static {
        System.out.println("|||||||||||||||Loading Cookie");
    }
}

class Gum {
    static {
        System.out.println("||||||||||||||Loading Gum");
    }
}

class Candy {
    static {
        System.out.println("|||||||||||||||Loading Candy");
    }
}

class A {}

public class SweetShop {

    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> inside main");
        new Candy();
        try {
            Class.forName("_typeinfo.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("After Class.forName(\"Gum\")");
        new Cookie();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> After creating Cookie");
        new Cookie();

        Stream.of(1, 2, 3, 4).forEach(i -> {
            throw new RuntimeException();
        });
    }

}
