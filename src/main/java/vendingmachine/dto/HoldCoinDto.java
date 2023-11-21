package vendingmachine.dto;

import java.util.Map;
import vendingmachine.domain.Coin;

public class HoldCoinDto {
    private Map<Coin, Integer> coins;

    private HoldCoinDto(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public static HoldCoinDto from(Map<Coin, Integer> coins) {
        return new HoldCoinDto(coins);
    }
    public int get500Count() {
        return coins.get(Coin.COIN_500);
    }

    public int get100Count() {
        return coins.get(Coin.COIN_100);
    }

    public int get50Count() {
        return coins.get(Coin.COIN_50);
    }

    public int get10Count() {
        return coins.get(Coin.COIN_10);
    }
}
