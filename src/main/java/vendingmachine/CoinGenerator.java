package vendingmachine;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinGenerator {
    private static final int COIN10 = 0;
    private static final int COIN50 = 1;
    private static final int COIN100 = 2;
    private static final int COIN500 = 3;
    private static final int coinAll[] = new int[]{10, 50, 100, 500};

    public Map<Coin, Integer> generate(int holdMoney) {
        HashMap<Coin, Integer> result = new HashMap<>();
        int coins[][] = countCoins(holdMoney, List.of(0, 1, 2, 3));
        result.put(Coin.COIN_10, coins[COIN10][0]);
        result.put(Coin.COIN_50, coins[COIN50][0]);
        result.put(Coin.COIN_100, coins[COIN100][0]);
        result.put(Coin.COIN_500, coins[COIN500][0]); //TODO : toStream
        return Collections.unmodifiableMap(result);
    }

    private int[][] countCoins(int holdMoney, final List<Integer> items) {
        int coins[][] = new int[Coin.values().length][1];
        while(holdMoney > 0) {
            int coin = pickNumberInList(items);
            if(holdMoney >= coinAll[coin]){
                holdMoney -= coinAll[coin];
                coins[coin][0]++;
            }
        }
        return coins;
    }
}
