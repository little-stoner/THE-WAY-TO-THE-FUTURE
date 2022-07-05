package refactor.java.ch08;

public class ChangeValueToReference {
    class Customer {
        private Customer() {
        }

        public static Customer create(String name) {
            return new Customer(name);
        }
    }

    class Order {
        private Customer _customer;

        public Order(String customer) {
            _customer = Customer.create(customer);
        }
    }
}
