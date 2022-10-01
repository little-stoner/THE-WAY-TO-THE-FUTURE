package _typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types =
            new ArrayList<Class<? extends Pet>>();
    // Types that you want to be randomly created:
    private static String[] typeNames = {
            "_typeinfo.pets.Mutt",
            "_typeinfo.pets.Pug",
            "_typeinfo.pets.EgyptianMau",
            "_typeinfo.pets.Manx",
            "_typeinfo.pets.Cymric",
            "_typeinfo.pets.Rat",
            "_typeinfo.pets.Mouse",
            "_typeinfo.pets.Hamster"
    };
//    private static Class[] typeNames = {
//            Mutt.class,
//            Pug.class,
//            EgyptianMau.class,
//            Manx.class,
//            Cymric.class,
//            Rat.class,
//            Mouse.class,
//            Hamste.class
//    };
    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for(String name : typeNames)
                types.add(
                        (Class<? extends Pet>)Class.forName(name));
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    static { loader(); }
    @Override
    public List<Class<? extends Pet>> types() {return types;}
} ///:~