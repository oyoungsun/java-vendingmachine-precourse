package vendingmachine.domain;

import java.util.HashMap;

public class Products {
    private final HashMap<Product, Integer> products;

    public Products(final HashMap<Product, Integer> products) {
        this.products = products;
    }

    public static Products from(final HashMap<Product, Integer> products) {
        return new Products(products);
    }

}
