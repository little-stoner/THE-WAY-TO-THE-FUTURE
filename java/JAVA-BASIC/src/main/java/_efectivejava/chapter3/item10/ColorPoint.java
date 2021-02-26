package _efectivejava.chapter3.item10;

import java.util.Objects;

public class ColorPoint extends Point {

    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    /** violate symmetry!!
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint)) {
            return false;
        }
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println(" ========================== ");
        System.out.println(Objects.equals(p, cp));
        System.out.println(Objects.equals(cp, p));
        System.out.println(" ========================== ");
    }
     **/

    /** violate transitivity !!
    @Override
    public boolean equals(Object o) {
        if (! (o instanceof Point)) {
            return false;
        }
        if (! (o instanceof ColorPoint)) {
            return o.equals(this);
        }
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    public static void main(String[] args) {
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
    }
    **/

}
