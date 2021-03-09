import java.util.*;

import java.util.concurrent.*;

public class Executor {

    public static void main(String[] args) throws Exception {

        System.out.println(-1 << 29);

        System.out.println(Integer.toBinaryString((1 << 29) - 1));        
        System.out.println(" ---------------------------- ");

        System.out.println(Integer.toBinaryString(-1 << 29));
        System.out.println(Integer.toBinaryString(0 << 29));               
        System.out.println(Integer.toBinaryString(1 << 29));
        System.out.println(Integer.toBinaryString(2 << 29));
        System.out.println(Integer.toBinaryString(3 << 29));        

        System.out.println("============================");
        
        System.out.println(Integer.toBinaryString(~((1 << 29) - 1)));

        System.out.println("============================");
        
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-536870912));
        System.out.println(Integer.toBinaryString(((-1 << 29) | 0)));

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0; i < 5; i++) {
            exec.execute(() -> { System.out.println(" *** "); })
        }
        exec.shutdown();
        
    }
    
}
