package _onjava8._interfaces;

interface Bob1 {
    default void bob() {
        System.out.println(" Bob1::bob ");
    }
}
interface Bob2 {
    default void bob() {
        System.out.println("Bob2::bob");
    }
}

// class Bob implements Bob1, Bob2 {}

interface Sam1 {
    default void sam() {
        System.out.println(" Sam1::sam ");
    }
}

interface Sam2 {
    default void sam(int i) {
        System.out.println(i * 2);
    }
}

class Sam implements Sam1, Sam2 {}

interface Max1 {
    default void max() {
        System.out.println("Max1::max");
    }
}

interface Max2 {
    default int max() {
        return 47;
    }
}

public class MICollision {
}
