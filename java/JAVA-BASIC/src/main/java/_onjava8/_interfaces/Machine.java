package _onjava8._interfaces;

import _efectivejava.lambda.item42.Operation;
import _onjava.Operations;
import org.checkerframework.checker.units.qual.C;

class Bing implements Operations {
    @Override
    public void execute() {
        Operations.show("Bing");
    }
}

class Crack implements Operations {
    @Override
    public void execute() {
        Operations.show("Crack");
    }
}

class Twist implements Operations {
    @Override
    public void execute() {
        Operations.show("Twist");
    }
}

public class Machine {

    public static void main(String[] args) {
        Operations.runOps(
                new Bing(), new Crack(), new Twist()
        );
    }

}
