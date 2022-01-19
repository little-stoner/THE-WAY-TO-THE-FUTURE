package _efectivejava._concurrency.item79;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set<E> set) {
        super(set);
    }

    private final List<SetObserver<E>> observers = new ArrayList<SetObserver<E>>();

    public void addObserver(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

    // This method is the culprit
    private void notifyElementAdded(E element) {
        synchronized (observers) {
            for (SetObserver<E> observer : observers)
                observer.added(this, element);
        }
    }

    // Alien method moved outside of synchronized block - open calls - Page 268
    // private void notifyElementAdded(E element) {
    // List<SetObserver<E>> snapshot = null;
    // synchronized(observers) {
    // snapshot = new ArrayList<SetObserver<E>>(observers);
    // }
    // for (SetObserver<E> observer : snapshot)
    // observer.added(this, element);
    // }

    // Thread-safe observable set with CopyOnWriteArrayList - Page 269
    //
    // private final List<SetObserver<E>> observers =
    // new CopyOnWriteArrayList<SetObserver<E>>();
    //
    // public void addObserver(SetObserver<E> observer) {
    // observers.add(observer);
    // }
    // public boolean removeObserver(SetObserver<E> observer) {
    // return observers.remove(observer);
    // }
    // private void notifyElementAdded(E element) {
    // for (SetObserver<E> observer : observers)
    // observer.added(this, element);
    // }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added)
            notifyElementAdded(element);
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c)
            result |= add(element); // calls notifyElementAdded
        return result;
    }

//    public static void main(String[] args) {
//        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
//        // set.addObserver((s, e) -> System.out.println(e));
//        set.addObserver(new SetObserver<Integer>() {
//            @Override
//            public void added(ObservableSet<Integer> set, Integer element) {
//                System.out.println(element);
//                if (element == 23){
//                    set.removeObserver(this);
//                }
//            }
//        });
//        for (int i=0; i < 100; i++) {
//            set.add(i);
//        }
//    }

    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if (element == 23) {
                    ExecutorService exec = Executors.newSingleThreadExecutor();
                    try {
                        System.out.println("++++++++++++++++++++++++++=");
                        exec.submit(() -> set.removeObserver(this)).get();
                    } catch (ExecutionException | InterruptedException e) {
                        throw new AssertionError(e);
                    } finally {
                        exec.shutdown();
                    }
                }
            }
        });
        for (int i=0; i < 100; i++) {
            set.add(i);
        }
    }

}