package _generics;


import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

class Product {
    private final int id;
    private String description;
    private double price;
    Product(int idNumber, String descr, double price) {
        id = idNumber;
        description = descr;
        this.price = price;
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Supplier<Product> generator = new Supplier<Product>() {
        private Random random = new Random(47);
        @Override
        public Product get() {
            return new Product(random.nextInt(1000), "Test", Math.round(random.nextDouble() * 1000.0) + 0.99);
        }
    };

}

class Shelf extends ArrayList<Product> {
    Shelf(int nProducts) {
//        Suppliers.fill(this, Product.generator, nProducts);
    }
}

class Aisle extends ArrayList<Shelf> {
    Aisle(int nShelves, int nProducts) {
        for( int i=0; i < nShelves; i++ ) {
            add(new Shelf(nProducts));
        }
    }
}

class CheckoutStand {}
class Office {}


public class Store extends ArrayList<Aisle> {

    private ArrayList<CheckoutStand> checkouts = new ArrayList<>();

    private Office office = new Office();

    public Store(
            int nAisles, int nShelves, int nProducts
    ) {
        for (int i = 0; i < nAisles; i++) {
            add(new Aisle(nShelves, nProducts));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Aisle a : this) {
            for (Shelf s : a) {
                for (Product p : s) {
                    sb.append(p);
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Store(5, 4, 3));
    }
}
