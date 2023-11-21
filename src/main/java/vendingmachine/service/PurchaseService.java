package vendingmachine.service;

import vendingmachine.domain.Products;

public class PurchaseService {

    private final Products products;
    private final int totalMoney;

    public PurchaseService(final Products products, final int inputMoney) {
        this.products = products;
        this.totalMoney = inputMoney;
    }

    public static PurchaseService from(final Products products, final int inputMoney) {
        return new PurchaseService(products, inputMoney);
    }

    public void purchase(){

    }
}
