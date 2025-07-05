package FawryTask;

import java.util.HashMap;

public class CheckoutService {
    public static void checkout(Customer customer, Cart cart) {
        if (cart.cart_products.isEmpty()) {
            System.out.println("the Cart is empty");

        } else {
            HashMap<Shipping, Integer> shippings = new HashMap<Shipping, Integer>();
            double subtotal = 0, shipping_fees = 0;

            for (Product p : cart.products) {
                String p_name;
                int p_quantity;
                if (cart.cart_products.containsKey(p.getName())) {
                    p_name = p.getName();
                    p_quantity = cart.cart_products.get(p.getName());

                    boolean isExpired = false;
                    if (p instanceof ExpirableProduct) {
                        isExpired = ((ExpirableProduct) p).expired();
                    } else if (p instanceof ExpirableShippable) {
                        isExpired = ((ExpirableShippable) p).expired();
                    }

                    if (isExpired) {
                        System.out.println(p_name + " is Expired !!!!!");
                    } else {
                        subtotal += p.getPrice() * p_quantity;

                        if (p instanceof Shipping) {
                            shippings.put((Shipping) p, p_quantity);
                            shipping_fees += 20 * p_quantity;
                        }
                    }
                }
            }
            double total = subtotal + shipping_fees;

            if (!customer.sufficent_balance(total)) {
                System.out.println("Insufficient balance for the payment");
                return;
            }
            customer.payment(total);

            if (shippings.size() > 0) {
                double totalWeight = 0;

                System.out.println("** Shipment notice **");
                for (Shipping p : shippings.keySet()) {
                    double w = p.getWeight() * shippings.get(p);
                    System.out.printf("%-20s %10.2f%n", shippings.get(p) + "x " + p.getName(), w);
                    totalWeight += w;
                }
                totalWeight /= 1000;
                System.out.println("Total package weight " + totalWeight + "kg");
            }

            System.out.println("** Checkout receipt **");
            for (Product p : cart.products) {
                String p_name;
                double p_quantity, p_price;
                if (cart.cart_products.containsKey(p.getName())) {
                    p_name = p.getName();
                    p_quantity = cart.cart_products.get(p.getName());
                    p_price = p_quantity * p.getPrice();
                    System.out.printf("%-20s %10.2f%n", (int) p_quantity + "x " + p_name, p_price);
                }
            }
            System.out.println("-------------------------------");
            System.out.printf("%-20s %10.2f%n", "Subtotal", subtotal);
            System.out.printf("%-20s %10.2f%n", "Shipping", shipping_fees);
            System.out.printf("%-20s %10.2f%n", "Amount", total);

        }

    }
}
