package _onjava8._generics;


class Base{}
class Derived extends Base {}

interface OrdinaryGetter {
    Base get();
}

interface DerivedGetter extends OrdinaryGetter {
    @Override
    Derived get();
}

public class CovariantReturnTypes {

    void test(DerivedGetter d) {
        Derived d2 = d.get();
    }

}
