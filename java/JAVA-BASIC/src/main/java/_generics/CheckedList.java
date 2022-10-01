package _generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {

    static class Cat{}
    static class Dog{}

    static void oldStylemethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStylemethod(dogs1);

        List<Dog> dogs2 = Collections.checkedList(new ArrayList<>(), Dog.class);

        try {
            oldStylemethod(dogs2);
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
//
//        List<Pet> pets = Collections.checkedList(new ArrayList<>(), Pet.class);
//        pets.add(new Dog());
//        pets.add(new Cat());

    }
}
