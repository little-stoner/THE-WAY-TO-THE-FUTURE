import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.locks.LockSupport;

public final class LockSupportDemo {


    public static void main(String[] args) throws Exception {


        Thread t = new Thread(() -> {
                System.out.println(">>>>>>>>>>>>>>>");
                LockSupport.park();
                System.out.println("<<<<<<<<<<<<<<<<");
        });
        t.start();

        
        
    }
}
