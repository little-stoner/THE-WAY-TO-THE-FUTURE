package _concurrency.jcip;


import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class LazyInitRace {

    static class ExpensiveObject{}

    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }
}
