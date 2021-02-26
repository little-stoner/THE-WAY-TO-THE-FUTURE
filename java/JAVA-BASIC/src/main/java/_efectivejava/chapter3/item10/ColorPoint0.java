package _efectivejava.chapter3.item10;

import java.util.Objects;

public class ColorPoint0 {

    private Color color;
    private Point point;

    public ColorPoint0(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
       if (!(o instanceof ColorPoint0)) {
           return false;
       }
       ColorPoint0 cp = (ColorPoint0) o;
       return cp.point.equals(point) && cp.color.equals(color);
    }

    @Override
    public int hashCode() {
        return 31 * point.hashCode() + color.hashCode();
    }
}
