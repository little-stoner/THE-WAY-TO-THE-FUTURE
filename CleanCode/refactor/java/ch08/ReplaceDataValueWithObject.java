package refactor.java.ch08;

public class ReplaceDataValueWithObject {
    class Order {
        public Order(String customer) {
            _customer = customer;
        }

        public String getCustomer() {
            return _customer;
        }

        public void setCustomer(String customer) {
            _customer = customer;
        }

        private String _customer;
    }

    class Customer {
        public Customer(String name) {
            _name = name;
        }

        public String getName() {
            return _name;
        }

        private final String _name;
    }

    class Order0 {
        public Order0(String customer) {
            _customer = new Customer(customer);
        }

        public String getCustomer() {
            return _customer.getName();
        }

        private Customer _customer;

        public void setCustomer(String arg) {
            _customer = new Customer(arg);
        }
    }
}
