package _concurrency.jcip;

public class ExtendSync {

    private static class P {
        public void p() {
            synchronized (this) {
                System.out.println(">>>>>>>>>>>>> enter P <<<<<<<<<<<<<<<<<<<");
                System.out.println(">>>>>>>>>>>>>>>>>>>>");
            }
            System.out.println(">>>>>>>>>>>>> exit P <<<<<<<<<<<<<<<<<<<");
        }
    }

    private static class C extends P {
        public void c() throws InterruptedException {

            synchronized (this) {
                System.out.println(">>>>>>>>>>>>> enter C <<<<<<<<<<<<<<<<<<<");
                Thread.sleep(2000);
                System.out.println("##########################");
            }
            System.out.println(">>>>>>>>>>>>> exit C <<<<<<<<<<<<<<<<<<<");
        }
        @Override
        public void p() {
            //super.p();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        C c = new C();
        new Thread(() -> {
            try {
                c.c();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> c.p()).start();
    }


}
