package _concurrent;

public class Philosopher implements Runnable {

    private final int seat;
    private final StickHolder left, right;
    public Philosopher(int sear, StickHolder left, StickHolder right) {
        this.seat = sear;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "seat=" + seat +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Thinking!!!!!!!!!!");    // [1]
            right.pickUp();
            left.pickUp();
            System.out.println(this + " eating ~~~~~~~~~~~");
            right.putDown();
            left.putDown();
        }
    }
}
