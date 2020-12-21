package _onjava8._generics;


import java.util.function.Consumer;

class PerformingDoaA extends Dog {
    public void speak() {
        System.out.println("Woof!");
    }
    public void sit() {
        System.out.println("Sitting ");
    }
    public void reproduce() {}
}

class RobotA {
    public void speak() {
        System.out.println("Click!");
    }
    public void sit() {
        System.out.println("Clank!");
    }
    public void oilChange() {}
}

class CommunicateA {
    public static <P> void perform(P performer,
                                   Consumer<P> action1, Consumer<P> action2) {
        action1.accept(performer);
        action2.accept(performer);
    }
}

public class DogsAndRobotMethodReferences {
    public static void main(String[] args) {

        CommunicateA.perform(new PerformingDoaA(),
                PerformingDoaA::speak, PerformingDoaA::sit);

        CommunicateA.perform(new RobotA(), RobotA::speak, RobotA::sit);

    }
}
