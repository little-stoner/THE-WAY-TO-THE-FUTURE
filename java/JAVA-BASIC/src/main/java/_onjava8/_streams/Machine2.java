package _onjava8._streams;

import _efectivejava.lambda.item42.Operation;
import _onjava.Operations;

import java.util.Arrays;

public class Machine2 {
    public static void main(String[] args) {
        Arrays.stream(new Operations[] {
                () -> Operations.show("Bing"),
                () -> Operations.show("Crack"),
                () -> Operations.show("Twist"),
                () -> Operations.show("Pop")
        }).forEach(Operations::execute);
    }
}
