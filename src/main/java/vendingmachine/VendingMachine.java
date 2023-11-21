package vendingmachine;

import java.util.Collections;
import java.util.Map;

public class VendingMachine {
    public final int holdMoney;
    public final Map<Coin, Integer> coins;

    public VendingMachine(final int holdMoney, final CoinGenerator generator) {
        this.holdMoney = holdMoney;
        this.coins = generator.generate(holdMoney);
    }

    public static VendingMachine from(final int holdMoney, final CoinGenerator generator) {
        //TODO : validate
        return new VendingMachine(holdMoney, generator);
    }

    public Map<Coin, Integer> getCoins() {
        return Collections.unmodifiableMap(coins);
    }
}
