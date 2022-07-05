package refactor.java.ch09;

import refactor.java.ch01.Customer;

public class IntroduceNullObject {
    class NullCustomer extends Customer {
        public boolean isNull() {
            return true;
        }
    }
    class Customer {
        public boolean isNull() {
            return false;
        }
    }
    interface Null {}
    class NullCustomer extends Customer implements Null {
        public boolean isNull() {
            return true;
        }
    }
}
