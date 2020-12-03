package _onjava8._polymorphism;

import _onjava8._polymorphism.shape.RandomShapes;
import _onjava8._polymorphism.shape.Shape;

public class Shapes {

    public static void main(String[] args) {
        RandomShapes gen = new RandomShapes();
        for (Shape shape : gen.array(9)) {
            shape.draw();
        }
    }

}
