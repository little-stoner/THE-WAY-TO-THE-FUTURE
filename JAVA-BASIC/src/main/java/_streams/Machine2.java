package _streams;

import _onjava.Operations;

import java.util.Arrays;

public class Machine2 {

    public static void main(String[] args) {
        Arrays.stream(new Operations[] {
                () -> Operations.show("LLL")
        }).forEach(Operations::execute);
    }

}
