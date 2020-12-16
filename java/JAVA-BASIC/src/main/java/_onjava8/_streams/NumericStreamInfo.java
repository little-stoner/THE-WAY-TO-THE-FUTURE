package _onjava8._streams;

import static _onjava8._streams.RandInts.rands;

public class NumericStreamInfo {
    public static void main(String[] args) {
        System.out.println(rands().average().getAsDouble());
        System.out.println(rands().sum());
        System.out.println(rands().summaryStatistics());
    }
}
