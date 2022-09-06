//package _efectivejava.chapter2.item8;
//
//import sun.misc.Cleaner;
//
//
///**
// * @author viber
// */
//public class Room implements AutoCloseable {
//
//    private static final Cleaner cleaner = Cleaner.create();
//    private static class State implements Runnable {
//        int numJunkPiles;
//        State(int numJunkPiles) {
//            this.numJunkPiles = numJunkPiles;
//        }
//
//        @Override
//        public void run() {
//            System.out.println("Cleaning room");
//            numJunkPiles = 0;
//        }
//    }
//    private final State state;
//    private final Cleaner cleanable;
//    public Room(int numJunkPiles) {
//        state = new State(numJunkPiles);
//        cleanable = cleaner.(this, state);
//    }
//
//    @Override
//    public void close() {
//        cleanable.clean();
//    }
//}
