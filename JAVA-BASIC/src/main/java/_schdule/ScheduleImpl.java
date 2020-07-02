package _schdule;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleImpl implements Scheduler {

    private volatile boolean shuttingDown = false;

    private Thread schedulerThread;


    @Override
    public void init() {

    }

    @Override
    public void start() {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public boolean isShutdown() {
        return shuttingDown;
    }

    static volatile boolean loop = true;

    public static void main(String[] args) throws Exception {
//        ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
//        schedule.scheduleAtFixedRate(() -> {
//            System.out.println(">>>>>>>>> " + new Date().toString());
//        }, 8, 8, TimeUnit.SECONDS);

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                while (loop) {
                    System.out.println("I am in infinity loop");
                }
            }
        });
//        a.setDaemon(true);
        a.start();
        System.out.println("a : " + a);
        loop = false;
        if (a.getState() != Thread.State.TERMINATED) {
            System.out.println("thread not terminated");
            Thread.sleep(1000);
        }
        System.out.println("a : " + a);
    }

}
