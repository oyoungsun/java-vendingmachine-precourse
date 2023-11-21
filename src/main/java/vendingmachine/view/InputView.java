package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Coin;

public class InputView {
    private static final String NUMBER_FORMAT = "정수의 범위가 아닙니다";
    private static final String BOUNDARY = "보유 금액은 0원 이상입니다";

    private static final String NOT_MONEY = "동전의 단위가 아닙니다";

    public int readHoldMoney() {
        int input = readInt();
        if(input < 0 ) throw new IllegalArgumentException(BOUNDARY);
        if(input% Coin.COIN_10.getAmount()!=0){
            throw new IllegalArgumentException(NOT_MONEY);
        }
        return input;
    }

    private int readInt() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_FORMAT);
        }
    }
}
