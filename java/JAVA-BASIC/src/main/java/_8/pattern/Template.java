package _8.pattern;

import java.util.function.Consumer;

public class Template {

    public static class Customer {}
    public static class Database {
        public static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }
    abstract class OnlineBanking {
        public void processCustomer(int id){
            Customer c = Database.getCustomerWithId(id);
            makeCustomerHappy(c);
        }
        abstract void makeCustomerHappy(Customer c);
    }

    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }



}
