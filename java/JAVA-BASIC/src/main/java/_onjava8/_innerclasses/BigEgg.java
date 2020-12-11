package _onjava8._innerclasses;

class Egg {
    private Yolk y;
    protected class Yolk {
        public Yolk() {
            System.out.println(" Egg.Yolk()");
        }
    }
    Egg() {
        System.out.println(" new Egg() ");
        y = new Yolk();
    }
}

public class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            System.out.println(" BigEgg.Yolk() ");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }
}
