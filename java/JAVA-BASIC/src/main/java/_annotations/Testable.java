package _annotations;

import _onjava.atunit.Test;

public class Testable {
    public void execute() {
        System.out.println("Executing...");
    }
    @Test
    void testExecute() { execute(); }
}
