package FawryTask;

import java.time.LocalDate;

class ExpirableProduct extends Product {
    public LocalDate expire_date;

    public ExpirableProduct(String name, double price, int quantity, LocalDate expire_date) {
        super(name, price, quantity);
        this.expire_date = expire_date;
    }

    public boolean expired() {
        return expire_date.isBefore(LocalDate.now());
    }
}