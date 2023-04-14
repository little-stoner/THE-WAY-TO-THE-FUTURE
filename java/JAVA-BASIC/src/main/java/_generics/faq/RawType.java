package _generics.faq;

public class RawType {

    interface Copyable<T> {
        T copy();
    }
    final static class Wrapped<Elem extends Copyable<Elem>> {
        private Elem theObject;
        public Wrapped(Elem arg) {
            theObject = arg.copy();
        }

        public void setTheObject(Elem arg) {
            theObject = arg.copy();
        }

        public Elem getObject() {
            return theObject.copy();
        }

        public boolean equals(Object other) {
            if (other == null) return false;
            if (!(other instanceof Wrapped)) return false;
            return (this.theObject.equals(((Wrapped) other).theObject));
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
    static void test(Wrapped wrapper) {
        wrapper.setTheObject(new MyString("kkk"));
        Object s = wrapper.getObject();
    }
    public static void main(String[] args) {
        Wrapped<MyString> wrapper = new Wrapped<>(new MyString("Citibank"));
        test(wrapper);
    }

}
