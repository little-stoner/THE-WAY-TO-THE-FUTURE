package _patterns.state;

public class S {
    interface StateBase {
        void f();
        void g();
        void h();
        void changeImp(StateBase newImp);
    }
    private static class State implements StateBase {
        private StateBase implementation;
        State(StateBase imp) {
            this.implementation = imp;
        }
        @Override
        public void changeImp(StateBase newImp) {
            implementation = newImp;
        }
        @Override
        public void f() {}
        @Override
        public void g() {}
        @Override
        public void h() {}
    }
    private static class Implementation1 implements StateBase {
        @Override
        public void f() {
            System.out.println("Implementation1.f()");
        }

        @Override
        public void g() {
            System.out.println("Implementation1.g()");
        }

        @Override
        public void h() {
            System.out.println("Implementation.h()");
        }

        @Override
        public void changeImp(StateBase newImp) {

        }
    }
    private static class Implementation2 implements StateBase {
        @Override
        public void f() {
            System.out.println("Implementation2.f()");
        }

        @Override
        public void g() {
            System.out.println("Implementation.g()");
        }

        @Override
        public void h() {
            System.out.println("Implementation.h()");
        }

        @Override
        public void changeImp(StateBase newImp) {

        }
    }
    private static void test(StateBase b) {
        b.f();
    }
    public static void main(String[] args) {
        StateBase b = new State(new Implementation1());
        test(b);
        b.changeImp(new Implementation2());
        test(b);
    }
}
