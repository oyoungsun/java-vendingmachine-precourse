package vendingmachine;

import java.util.Map;

public class VendingMachine {
    public final int holdMoney;
    public final Map<Coin, Integer> coins;

    public VendingMachine(final int holdMoney, final CoinGenerator generator) {
        this.holdMoney = holdMoney;
        this.coins = generator.generate();
    }

    public static VendingMachine from(final int holdMoney, final CoinGenerator generator) {
        //TODO : validate
        return new VendingMachine(holdMoney, generator);
    }
}
