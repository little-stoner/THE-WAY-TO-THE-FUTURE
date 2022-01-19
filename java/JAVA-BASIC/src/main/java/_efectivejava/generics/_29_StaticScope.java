package _efectivejava.generics;

import edu.princeton.cs.algs4.Count;

public class _29_StaticScope {

   public static class Counted<T> {
       public static final int MAX = 1024;
       public static class BeyondThresholdException extends Exception {}
       private static int count;
       private static int getCount() { return count; }
       private final T value;
       public Counted(T arg) throws BeyondThresholdException {
           this.value = arg;
           count++;
           if (count >= 1024) {
               throw new BeyondThresholdException();
           }
       }

       @Override
       protected void finalize() throws Throwable {
           count--;
       }

       public T getValue() {
           return value;
       }
   }

    public static void main(String[] args) {
        int m = Counted.MAX;
        // int k = Counted<Long>.MAX;
        // int n = Counted<?>.MAX;
    }

}
