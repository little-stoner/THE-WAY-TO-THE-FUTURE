package _efectivejava.chapter2.item9;

public class AutoClosableResource implements AutoCloseable {

    private String name = null;
    private boolean throwExceptionOnClose = false;

    public AutoClosableResource(String name, boolean throwExceptionOnClose) {
        this.name = name;
        this.throwExceptionOnClose = throwExceptionOnClose;
    }

    public void doOp(boolean throwException) throws Exception {
        System.out.println("Resource " + this.name + " doing operation");
        if (throwException) {
            throw new Exception("Error when calling doOp() on resource " + this.name);
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("Resource " + this.name + " close() called");
        if (this.throwExceptionOnClose) {
            throw new Exception("Error when trying to close resource " + this.name);
        }
    }

    public static void main(String[] args) {
        try {
            tryWithResourcesTwoResources();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("==================================");
            Throwable[] suppressed = e.getSuppressed();
            System.out.println("suppressed = " + suppressed);
        }
    }

    public static void tryWithResourcesTwoResources() throws Exception {
        try (AutoClosableResource resourceOne = new AutoClosableResource("One", true);
             AutoClosableResource resourceTwo = new AutoClosableResource("Two", true)
        ) {
            resourceOne.doOp(true);
            resourceTwo.doOp(false);
        }
    }

}
