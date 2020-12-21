package _onjava8._typeinfo.toys;

import com.google.common.collect.HashBasedTable;

import java.nio.file.WatchEvent;
import java.util.HashSet;

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}

class Toy {
    Toy() {}
    Toy(int i) {}
}
class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() { super(1);}
}

public class ToyTest {
    static void printInfo(Class cc) {
        System.out.println(" Class Name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println(" Simple name: " + cc.getSimpleName());
        System.out.println(" Cannonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            // c = Class.forName("/Users/viber/Mamba/THE-WAY-TO-THE-FUTURE/java/JAVA-BASIC/src/main/java/_onjava8/_typeinfo/toys/FancyToy");
            c = FancyToy.class;
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces())
            printInfo(face);
        System.out.println(" ====================== ");
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj  = up.newInstance();
        } catch (Exception e) {
            System.out.println("");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
