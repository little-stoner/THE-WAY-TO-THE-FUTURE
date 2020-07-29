package _collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Snow {}
class Slush extends Snow {}


public class AsListInference {

    public static void main(String[] args) {
        
        List<Snow> snow1 = Arrays.asList(
                new Crusty(), new Slush(), new Powder()
        );
        snow1.add(new Heavy());
        List<Snow> snow2 = Arrays.asList(
                new Light(), new Heavy()
        );
        snow2.add(new Slush());

        List<Snow> snow3 = new ArrayList<>();
        Collections.addAll(snow3,
                new Light(), new Heavy(), new Powder());

        List<Snow> snow4 = Arrays.<Snow>asList(
                new Light(), new Heavy(), new Slush()
        );
        snow4.add(new Powder());

    }


}
