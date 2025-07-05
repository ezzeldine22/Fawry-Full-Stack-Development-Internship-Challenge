package FawryTask;

import java.time.LocalDate;
import java.util.ArrayList;

public class Repository {
    public ArrayList<Product> products() {
        ArrayList<Product> arr = new ArrayList<>();

        ExpirableShippable cheese = new ExpirableShippable("cheese", 100, 10, LocalDate.of(2026, 12, 10), 500);
        ExpirableProduct biscuits = new ExpirableProduct("biscuits", 150, 20, LocalDate.of(2026, 10, 7));
        ShippableProduct tv = new ShippableProduct("tv", 200, 30, 500);
        Product mobile = new Product("mobile", 300, 50);
        Product scratchCard = new Product("scratchCard", 30, 17);
        arr.add(cheese);
        arr.add(biscuits);
        arr.add(tv);
        arr.add(mobile);
        arr.add(scratchCard);

        return arr;
    }
}
