package _concurrency.jcip;

public class Widget {

    public synchronized void doSomething() {
        System.out.println(">>>>>>>>>> [ Calling Widget ] <<<<<<<<<<<");
    }

    static class LoggingWidget extends Widget {
        @Override
        public synchronized void doSomething() {
            System.out.println("====> Calling LoggingWidget <====");
            super.doSomething();
        }
    }

    public static void main(String[] args) {
        Widget w = new LoggingWidget();
        w.doSomething();
    }

}
