package _onjava8._typeinfo;

class Building {}
class House extends Building {}
public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseClass = House.class;
        House h = houseClass.cast(b);
        h = (House) b;
    }
}
