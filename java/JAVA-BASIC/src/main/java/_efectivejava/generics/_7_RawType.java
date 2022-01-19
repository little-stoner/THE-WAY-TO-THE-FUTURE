package _efectivejava.generics;

public class _7_RawType {

    interface Copyable<T> {
        T copy();
    }

    static final class Wrapped<Elem extends Copyable<Elem>> {
        private Elem theObject;

        public Wrapped(Elem arg) {
            theObject = arg.copy();
        }

        public void setObject(Elem arg) {
            theObject = arg.copy();
        }

        public Elem getObject() {
            return theObject.copy();
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }
            if (!(other instanceof Wrapped)) {
                return false;
            }
            return (this.theObject.equals(((Wrapped) other).theObject));
        }
    }

    /** **/
    interface CopyableRaw {
        Object copy();
    }

    static final class WrappedRaw {
        private CopyableRaw theObject;

        public WrappedRaw(CopyableRaw arg) {
            theObject = (CopyableRaw) arg.copy();
        }

        public void setObject(CopyableRaw arg) {
            theObject = (CopyableRaw) arg.copy();
        }

        public CopyableRaw getObject() {
            return (CopyableRaw) theObject.copy();
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }
            if (!(other instanceof WrappedRaw)) {
                return false;
            }
            return (this.theObject.equals(((WrappedRaw) other).theObject));
        }
    }

    static class MyString implements Copyable<MyString> {
        private StringBuilder buffer;

        public MyString(String s) {
            buffer = new StringBuilder(s);
        }

        @Override
        public MyString copy() {
            return new MyString(buffer.toString());
        }
    }

    static class Test {
        private static void test(Wrapped wrapper) {
            wrapper.setObject(new MyString("Deutsche Bank")); // unchecked warning
            Object s = wrapper.getObject();
        }

        public static void main(String[] args) {
            Wrapped<MyString> wrapper = new Wrapped<MyString>(new MyString("Citibank"));
            test(wrapper);
        }
    }

}
