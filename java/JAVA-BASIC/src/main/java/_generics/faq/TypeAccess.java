package _generics.faq;

public class TypeAccess {
    private static class SuperClass {
        public enum EnumType {A, B}

        public static Object staticField;

        public static String staticMethod() {
            return "";
        }

        public class InnerClass {
        }

        public Object instanceField;

        public String instanceMethod() {
            return "";
        }

        public SuperClass() {
        }

        private Object privateField;
    }

    private final static class SomeClass<T extends SuperClass> {
        private T object;

        public SomeClass(T t) {
            object = t;
        }

        @Override
        public String toString() {
            return
                    "static nested type       : " + T.EnumType.class + " \n"
                            + "static field             : " + T.staticField + "\n"
                            + "static method            : " + T.staticMethod() + "\n"
                            + "non-static nested type   : " + T.InnerClass.class + "\n"
                            + "non-static field         : " + object.instanceField + "\n"
                            + "non-static method        : " + object.instanceMethod() + "\n";
            // +   "constructor              : " + (new T()) + "\n"
            // +   "private member           : " + object.privateField + "\n";
        }
    }

}
