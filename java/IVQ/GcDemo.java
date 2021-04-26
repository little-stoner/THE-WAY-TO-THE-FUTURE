
public class GcDemo {

    private static int counter = 0;
    private final int id;
    
    public GcDemo() {
        id = counter++;
    }

    protected void finalize() throws Throwable {
        System.out.println("Garbage collector called");
        System.out.println("Object garbage collected : " + this);
    }

    public String toString() {
        return "GcDemo [" + id + "]";
    }    
    
    public static void main(String[] args) {

        GcDemo g1 = new GcDemo();
        GcDemo g2 = new GcDemo();

        g1 = null;
        System.gc();

        g2 = null;
        Runtime.getRuntime().gc();

        while(true) {
            
        }
        
    }
    
}
