package _onjava8._collections;

import _onjava8._typeinfo.pets.Hamster;
import _onjava8._typeinfo.pets.Pet;
import _onjava8._typeinfo.pets.Pets;
import _onjava8._typeinfo.pets.Rat;

import java.util.LinkedList;

public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets =
                new LinkedList<>(Pets.list(6));
        System.out.println(pets);

        System.out.println(
                "pets.getFirst(): " + pets.getFirst()
        );
        System.out.println(
                "pets.element(): " + pets.element()
        );
        System.out.println("pets.peek(): " + pets.peek());

        System.out.println("pets.remove(): " + pets.remove());

        System.out.println(
                "pets.removeFirst(): " + pets.removeFirst()
        );
        System.out.println("pets.poll(): " + pets.poll());
        System.out.println(pets);

        pets.addFirst(new Rat());
        System.out.println("After addFirst(): " + pets);

        pets.offer(Pets.get());
        System.out.println("After offer(): " + pets);

        pets.add(Pets.get());
        System.out.println("After add(): " + pets);

        pets.addLast(new Hamster());
        System.out.println("After addLast(): " + pets);
        System.out.println(
                "pets.removeLast(): " + pets.removeLast()
        );

    }

}
