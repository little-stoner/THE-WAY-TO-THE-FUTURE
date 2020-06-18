


/**
   Order of execution of Initializtion blocks and Constructors
 */


/**
   
 */

public class  ClassInitializationSequence {

    public static void main(String[] args) {
        new KB();
        System.out.println("======================");
        new KB(1);
        System.out.println(T.getSum());
    }
    
}


class KB {

    KB() {
        System.out.println(" No argument constructor");
    }

    KB(int i) {
        System.out.println(" ONE argument constructor, i = " + i);
    }

    static {
        System.out.println("1st static init");
    }

        {
            System.out.println("1st instance init");
        }
        {
            System.out.println("2nd instance init");
        }

    static {
        System.out.println("2nd static init");
    }
    
}

class GIGI extends KB {
    
}

class T {
    static {
        System.out.println(">>>>> static block initialization");
        System.out.println(">>>>> first initialize....");
        System.out.println("== initialized: " + T.initialized);        
        initialize();
        System.out.println(">>>>> sum: " + T.sum);
        System.out.println("== initialized: " + T.initialized);
    }
    private static int sum;
    public static int getSum() {
        initialize();
        return sum;
    }
    private static boolean initialized = false;
    private static void initialize() {
        System.out.println(">>>>>>> local initialized " + T.initialized);
        if (!initialized) {
            for (int i=0; i < 100; i++) {
                sum += i;
            }
            initialized = true;
        }
    }
}
