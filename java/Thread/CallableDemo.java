import java.util.*;

import java.util.concurrent.*;

public class CallableDemo {

    
    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();

        ArrayList<Future<String>> results = new ArrayList<>();

        for (int i=0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }

        for (Future<String>  fs : results) {
            try {
                System.out.println(fs.get());
            } catch(InterruptedException e) {
                System.out.println(e);
                return;
            } catch(ExecutionException e) {
                System.out.println(e);
                return;
            } finally {
                exec.shutdown();
            }
        }
        return " result of TaskWithResult " + id;
    }
}
