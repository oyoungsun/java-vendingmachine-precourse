package vendingmachine.domain;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public boolean isDivided(int price){
        return (price % this.amount) == 0;
    }

    public int getAmount() {
        return amount;
    }
}
