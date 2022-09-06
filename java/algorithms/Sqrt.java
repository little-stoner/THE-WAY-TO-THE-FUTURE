
public class Sqrt {

    public static double sqrt(double c) {
        if (c < 0) return Double.NaN;
        double err = 1e-15;
        double t = c;
        while (Math.asb(t - c/t) > err * t) {
            t = (c/t + t) / 2.0;
        }
        return t;
    }

    public static double hypotenuse(double a, double b) {
        return sqrt(a*a + b*b);
    }

    
    
}
