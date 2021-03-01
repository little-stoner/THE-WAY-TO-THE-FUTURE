import java.util.*;

import java.util.concurrent.*;

public class SimpleCompletableFuture {

        public static void main(String[] args) throws Exception {


            CompletableFuture<Void> c = CompletableFuture.runAsync(() -> {

                    try {
                        System.out.println("==> before start <== ");                        TimeUnit.SECONDS.sleep(1);                        
                        System.out.println(" ..... " + Thread.currentThread());
                        System.out.println("==> finish <== ");                             
                    } catch (Exception e) {
                        
                    }

                    
                });
            

            System.out.println(" ==> " + c.isDone());
            TimeUnit.SECONDS.sleep(2);
            System.out.println(" ==> " + c.isDone());
            
            System.out.println(">>>>>>>>");

            
        }
    
}
