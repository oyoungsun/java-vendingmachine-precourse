package vendingmachine.view;

public class OutputView {
    public static void printExceptionMessage(final String message, final String format) {
        System.out.println(String.format("%s %s", format, message));
    }

    public static void printRequestHoldMoney() {
        System.out.println(OutputMessage.REQUEST_HOLD_MONEY.getView());
    }
}
enum OutputMessage{
    REQUEST_HOLD_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
    HOLE_MONEY("자판기가 보유한 동전"),
    REQUEST_PRODUCTS("상품명과 가격, 수량을 입력해 주세요."),
    REQUEST_INPUT_MOENY("투입 금액을 입력해 주세요."),
    REMAIN_MONEY("투입 금액: %d원"),
    REQUEST_PURCHASE_PRODUCT("구매할 상품명을 입력해 주세요."),
    TOTAL_REMAIN("잔돈"),
    COIN_REMAIN("%d원 - %d개");

    private final String view;

    private OutputMessage(final String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }
}
