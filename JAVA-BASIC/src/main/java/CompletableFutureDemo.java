import java.util.*;
import java.util.concurrent.*;


public class CompletableFutureDemo {


    
    

    public static void main(String[] args) throws Exception {

        CompletableFuture.runAsync(() -> System.out.println(" ..... " + Thread.currentThread()));

        CompletableFuture.supplyAsync(() -> 5)
            .thenApply(i -> i * 3)
            .thenAccept(i -> System.out.println("The result is " + i))
            .thenRun(() -> System.out.println("Finished"));
        
    }
    
}
