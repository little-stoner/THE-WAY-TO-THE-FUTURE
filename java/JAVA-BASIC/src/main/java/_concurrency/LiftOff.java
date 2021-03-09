package _concurrency;

public class LiftOff implements Runnable {

    protected int countDown = 10;
    private static int taskCount = 0;

    private final int id = taskCount++;

    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }

    public String status() {
       return "#" + id + "(" +
               (countDown > 0 ? countDown : " Liftoff!") + "). ";
    }



    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        new Thread(new LiftOff()).start();
        launch.run();

        int a, b, c;
        a = b = c = 12;
        System.out.println(a + " " + b + " " + c);

        float f = 1;
        double d = 1;
        Float ff = 0f;
        System.out.println(" f: " + f);
        System.out.println(" d: " + d);
        System.out.println(" ff: " + ff );
    }

}
