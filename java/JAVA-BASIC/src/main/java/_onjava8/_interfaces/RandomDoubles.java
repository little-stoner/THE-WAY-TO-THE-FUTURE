package _onjava8._interfaces;

import java.util.Random;

public interface RandomDoubles {
    Random RAND = new Random(47);
    default double next() { return RAND.nextDouble(); }
    static void main(String[] args) {
        RandomDoubles rd = new RandomDoubles() {};
        for(int i = 0; i < 7; i ++)
            System.out.print(rd.next() + " ");
    }
}
