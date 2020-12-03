package _onjava8._resue;

public class DerivedSpaceShip extends SpaceShipControls {

    private String name;
    public DerivedSpaceShip(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DerivedSpaceShip{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        DerivedSpaceShip protector =
                new DerivedSpaceShip("NSEA Protector");
        protector.forward(100);
    }

}
