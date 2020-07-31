package _efectivejava.generics.item31;

import java.util.*;

public class Chooser<T> {

    private final List<T> choiceList;
    private final Random rand = new Random();

    public Chooser(Collection<? extends T> choices) {
        this.choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        return choiceList.get(rand.nextInt(choiceList.size()));
    }

    public static void main(String[] args) {

    }



}
