package _concurrent.completable;

public class Breakable {

    String id;
    private int failcount;
    public Breakable(String id, int failcount) {
        this.id = id;
        this.failcount = failcount;
    }

    @Override
    public String toString() {
        return "Breakable{" +
                "id='" + id + '\'' +
                ", failcount=" + failcount +
                '}';
    }

    public static Breakable work(Breakable b) {
        if (--b.failcount == 0) {
            System.out.println(" Throwing Exception for " + b.id + "");;
            throw new RuntimeException(" Breadkable_" + b.id + " failed ");
        }
        System.out.println(b);
        return b;
    }

}
