package refactor.java.ch08;

public class ReplaceMagicNumberWithSymbolicConstant {
    double potentialEnergy(double mass, double heitht) {
        return mass * 9.8 * heitht;
    }

    double potentialEnergy0(double mass, double heitht) {
        return mass * GRAVITATIONAL_CONSTANT * heitht;
    }
    static final double GRAVITATIONAL_CONSTANT = 9.81;
}
