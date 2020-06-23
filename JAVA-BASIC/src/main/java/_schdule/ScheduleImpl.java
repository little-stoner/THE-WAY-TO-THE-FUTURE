package _schdule;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleImpl implements Scheduler {


    public static void main(String[] args) throws Exception {
        ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
        schedule.scheduleAtFixedRate(() -> {
            System.out.println(">>>>>>>>> " + new Date().toString());
        }, 8, 8, TimeUnit.SECONDS);
    }

}
