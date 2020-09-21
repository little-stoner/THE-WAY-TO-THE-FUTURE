

public class DataOnly {

    // these fields can't be shared
    int i;
    double d;
    boolean b;
    // this field can be another object
    LeftTank lt = new LeftTank();

    public String toString() {
        return "i = " + i + " d = " + d
                + " b = " + b + " lt = " + lt;
    }

    public static void main(String[] args) {
        DataOnly d = new DataOnly();
        d.i = 47;
        d.d = 1.1;
        d.b = false;
        d.lt.capacity = 999;
        System.out.println(d);
    }

}

class LeftTank {
    int capacity;

    public String toString() {
        return capacity + "";
    }
}
