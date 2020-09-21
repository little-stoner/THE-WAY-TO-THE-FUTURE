package _generics;


class Hamster extends ComparablePet implements Comparable<ComparablePet> {
    @Override
    public int compareTo(ComparablePet o) {
        return super.compareTo(o);
    }
}

class Gecko extends ComparablePet {
    @Override
    public int compareTo(ComparablePet o) {
        return super.compareTo(o);
    }
}

public class RestrictedComparablePets {
}
