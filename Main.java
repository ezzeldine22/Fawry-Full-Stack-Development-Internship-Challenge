package FawryTask;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Ali", 5000);
        Cart cart = new Cart();

        cart.add("cheese", 2);
        cart.add("tv", 3);
        cart.add("scratchCard", 1);

        CheckoutService.checkout(customer, cart);
    }
}
