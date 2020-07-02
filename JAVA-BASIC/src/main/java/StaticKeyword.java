/**
 * This is about the `static` example.
 * <p>
 * Summary:
 * static field && static method
 * static field is shared across all instance of the class and
 * can be directly access with ClassName.
 * static mehtod can only access by Class.
 */

public class StaticKeyword {

    // this will init to 0
    private static int id;

    public static String printMe() {
        return id + "";
    }

    public StaticKeyword() {
        id++;
    }

    public static void main(String[] args) {
        System.out.println(" StaticKeyword.id = " + StaticKeyword.id);
        StaticKeyword s = new StaticKeyword();
        // directly get
        System.out.println(" StaticKeyword.id = " + StaticKeyword.id);
        // instance get
        System.out.println(" s.id = " + s.id);
        // use static method get
        System.out.println(" StaticKeyword.printMe() : " + StaticKeyword.printMe());
    }


}
