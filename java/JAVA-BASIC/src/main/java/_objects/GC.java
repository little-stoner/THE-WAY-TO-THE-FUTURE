package _objects;

public class GC {

    public static void main(String[] args) throws Exception  {

        GC g1 = new GC();
        GC g2 = new GC();

        g1 = null;

        System.gc();

        g2 = null;

        Runtime.getRuntime().gc();

        Thread.sleep(1000);

    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage collector called");
        System.out.println("Object garbage collected: " + this);
    }
}
