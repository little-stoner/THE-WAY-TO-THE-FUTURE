import java.util.*;

import java.util.concurrent.*;


public class MultiCompletableFuture {

            public static void main(String[] args) throws Exception {


            CompletableFuture<String> c0 = CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println("==> c0 before start <== ");                        TimeUnit.SECONDS.sleep(1);                        
                        System.out.println(" ..... " + Thread.currentThread());
                        System.out.println("==> c0 finish <== ");                             
                    } catch (Exception e) {
                        
                    }
                    return "0";
                });

            CompletableFuture<String> c1 = CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println("==> c1  before start <== ");                        TimeUnit.SECONDS.sleep(1);                        
                        System.out.println(" ..... " + Thread.currentThread());
                        System.out.println("==> c1 finish <== ");                             
                    } catch (Exception e) {
                        
                    }
                    return "1";
                });
            
            // CompletableFuture.allOf(c0, c1).join();
            CompletableFuture.allOf(c0, c1);
            TimeUnit.SECONDS.sleep(1);
            
            System.out.println(">>>>>>>>");

            
        }
}
