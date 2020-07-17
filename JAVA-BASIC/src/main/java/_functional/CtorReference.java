package _functional;

class Dog {
    String name;
    int age = -1;
    Dog() { name = "stray"; }
    Dog(String nm) { name = nm; }
    Dog(String nm, int yrs) { name = nm; age = yrs; }
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Arg {
    Dog make(String nm);
}

interface Make2Arg {
    Dog make(String nm, int age);
}

public class CtorReference {

    public static void main(String[] args) {
        MakeNoArgs mna = Dog::new;
        Make1Arg n1a = Dog::new;
        Make2Arg n2a = Dog::new;

        Dog dn = mna.make();
        Dog d2 = n1a.make("Comet");
        Dog d3 = n2a.make("Rlph", 4);
    }

}
