package _schdule;

public interface Scheduler {
    void init();

    void start();

    void shutdown();

    boolean isShutdown();
}
