// Question: How can a shopping cart hold products and calculate an order total?
package OOP;
// online shopping
//  CUSTOMER
//        NAME, ADDRESS
//        login(); logout(); selectProduct();
//    SHOPPING CART
//        items
//        add(item), remove(item);
//    PRODUCTS
//        name , price , qnt
//            order(); changePrice();

import java.util.ArrayList;
import java.util.List;


public class OnlineShopping {
    private static class Product {
        private final String name;
        private final double price;

        private Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    private static class ShoppingCart {
        private final List<Product> items = new ArrayList<>();

        private void add(Product product) { items.add(product); }
        private void remove(Product product) { items.remove(product); }
        private double total() {
            return items.stream().mapToDouble(product -> product.price).sum();
        }
    }

    public static void main(String[] args) {
        Product book = new Product("Java Basics", 45.00);
        Product notebook = new Product("Notebook", 12.50);
        ShoppingCart cart = new ShoppingCart();
        cart.add(book);
        cart.add(notebook);
        System.out.println("Items: " + book.name + ", " + notebook.name);
        System.out.printf("Total: %.2f%n", cart.total());
    }

}
