

//

public class EX4 {

    public static void main(String[] args) {
        class DataOnly {
            int i;
            double d;
            boolean b;
        }
        DataOnly do_ = new DataOnly();
        do_.i = 1;
        do_.d = 2.0;
        do_.b = false;
        System.out.println(" i: " + do_.i);
        System.out.println(" d: " + do_.d);
        System.out.println(" b: " + do_.b);        
    }
    
}
