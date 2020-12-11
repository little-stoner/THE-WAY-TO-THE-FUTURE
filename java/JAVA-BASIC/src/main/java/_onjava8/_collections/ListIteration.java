package _onjava8._collections;

import _onjava8._typeinfo.pets.Pet;
import _onjava8._typeinfo.pets.Pets;

import java.util.List;
import java.util.ListIterator;

public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.list(8);
        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next() + " ," +
                    it.nextIndex() + ", " +
                    it.previousIndex() + "; ");
        }
        System.out.println();
        // Backwards:
        while (it.hasPrevious()) {
            System.out.println(it.previous().id() + " ");
        }
        System.out.println();
        System.out.println(pets);
        it = pets.listIterator(3);
        while (it.hasNext()) {
            it.next();
            it.set(Pets.get());
        }
        System.out.println(pets);
    }
}
