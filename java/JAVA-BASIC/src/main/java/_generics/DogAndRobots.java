package _generics;


class Dog {

}

class PerformingDog extends Dog implements Performs {
    @Override
    public void speak() {

    }
    @Override
    public void sit() {

    }
    public void reproduce() {}
}

class Robot implements Performs {
    @Override
    public void speak() {

    }
    @Override
    public void sit() {

    }
    public void oilChange() {}
}

class Communicate {
    public static <T extends Performs> void perform(T performer) {
        performer.speak();
        performer.sit();
    }
}

public class DogAndRobots {
    public static void main(String[] args) {
        Communicate.perform(new PerformingDog());
        Communicate.perform(new Robot());
    }
}
