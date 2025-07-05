package FawryTask;

import java.time.LocalDate;

public class ExpirableShippable extends Product implements Shipping {
    public LocalDate expire_date;
    double weight;

    public ExpirableShippable(String name, double price, int quantity, LocalDate expire_date, double weight) {
        super(name, price, quantity);
        this.expire_date = expire_date;
        this.weight = weight;
    }

    public boolean expired() {
        return expire_date.isBefore(LocalDate.now());
    }

    public String getName() {
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }
}
