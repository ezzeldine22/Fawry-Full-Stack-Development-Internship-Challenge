package FawryTask;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
    Repository db = new Repository();
    public ArrayList<Product> products = db.products();

    public HashMap<String, Integer> cart_products = new HashMap<>();

    public void add(String productName, int quantity) {
        for (Product p : products) {
            if (p.getName().equals(productName)) {
                if (p.getQuantity() >= quantity) {
                    p.sold(quantity);
                    cart_products.put(productName, cart_products.getOrDefault(productName, 0) + quantity);
                } else {
                    System.out.println("No Enough Items Available for " + productName);
                }
                return;
            }
        }
        System.out.println("Product (" + productName + ") not found ");
    }
}