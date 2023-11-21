package vendingmachine.service;

import vendingmachine.domain.Products;

public class PurchaseService {

    private final Products products;

    public PurchaseService(final Products products) {
        this.products = products;
    }

    public static PurchaseService from(final Products products) {
        return new PurchaseService(products);
    }
}
