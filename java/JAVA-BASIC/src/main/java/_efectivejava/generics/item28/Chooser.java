package _efectivejava.generics.item28;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Chooser<T> {

    private final List<T> choiceList;

    public Chooser(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rand = ThreadLocalRandom.current();
        return choiceList.get(rand.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Chooser<Integer> chooser = new Chooser<>(intList);

    }

}
