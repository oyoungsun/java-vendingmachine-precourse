package vendingmachine.domain;

public class Product {
    private static final int MINIMUM_PRODUCT_PRICE = 100;
    private static final String PRICE_BOUNDARY = "상품 가격은 100원부터 시작합니다.";
    private static final String NOT_DEVIDEDBY_10 = "10원으로 나누어떨어져야 합니다.";

    private final String name;
    private final int price;

    public Product(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public static Product from(final String name, final int price) {
        if (price < MINIMUM_PRODUCT_PRICE) {
            throw new IllegalArgumentException(PRICE_BOUNDARY);
        }
        if (price % 10 != 0) {
            throw new IllegalArgumentException(NOT_DEVIDEDBY_10);
        }
        return new Product(name, price);
    }
}
