package FawryTask;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void payment(double value) {
        balance -= value;
    }

    public boolean sufficent_balance(double amount) {
        return balance >= amount;
    }
}
