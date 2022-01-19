package _efectivejava.generics;

import java.util.Collection;

public class _17_Parallel {

    static class Animal {

    }
    static class Fish extends Animal{}
    static class Cat extends Animal{}

    static class Habitat<A extends Animal> {
        protected Collection<A> theAnimals;
        public Habitat(){}
        public Habitat(Collection<A> theAnimals) {
            this.theAnimals = theAnimals;
        }
        public void addInhabitant(A animal) {
            theAnimals.add(animal);
        }
    }

    static class Aquarium extends Habitat<Fish> {
        public Aquarium() {}
        public Aquarium(Collection<Fish> fish) {
            super(fish);
        }
        @Override
        public void addInhabitant(Fish fish) { // no test necessary
            theAnimals.add(fish);
        }
    }

    public static void main(String[] args) {
        Aquarium a = new Aquarium();
        // a.addInhabitant(new Cat());
    }

}
