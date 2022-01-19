package _efectivejava.chapter2.item3;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author viber
 */

public class Elvis implements Serializable {

    private transient static final Elvis INSTANCE = new Elvis();
    private Elvis() {}

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();
    }

    private Object readResolve() {
        return INSTANCE;
    }

}
