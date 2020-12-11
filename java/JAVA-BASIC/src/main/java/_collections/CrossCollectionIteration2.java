package _collections;

import _onjava8._typeinfo.pets.Pet;
import _onjava8._typeinfo.pets.Pets;

import java.util.*;

public class CrossCollectionIteration2 {

    public static void display(Iterable<Pet> it) {
        Iterator<Pet> ip = it.iterator();
        while (ip.hasNext()) {
            Pet p = ip.next();
            System.out.println(p.id() + " : " + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> pets = Pets.list(8);
        LinkedList<Pet> petsLL = new LinkedList<>(pets);
        HashSet<Pet> petsHS = new HashSet<>(pets);
        TreeSet<Pet> petsTS = new TreeSet<>(pets);
        display(pets);
        display(petsLL);
        display(petsHS);
        display(petsTS);
    }


}
