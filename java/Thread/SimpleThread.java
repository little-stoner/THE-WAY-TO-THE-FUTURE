
import java.util.*;

import java.util.concurrent.TimeUnit;

public class SimpleThread {


    

    public static void main(String[] args) throws Exception {

        
        Thread t = new Thread(() -> {
                int count = 1;
                while(true) {
                    try {

                        TimeUnit.SECONDS.sleep(1);                        
                        System.out.println("[ # " + (count++) + " ]");

                        if (count == 20) {
                            break;
                        }

                    } catch (Exception e) {
                        
                    }
                    
                }
                System.out.println(" >>> Thread Finish <<< ");
        });

        t.start();

        
    }
    
}
