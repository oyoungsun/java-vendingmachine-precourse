package vendingmachine;

import vendingmachine.utils.ExceptionHandler;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final InputView inputView;
    private final CoinGenerator generator;
    private VendingMachine vendingMachine;

    public VendingMachineController(final InputView inputView, final CoinGenerator generator) {
        this.inputView = inputView;
        this.generator = generator;

    }

    public void run() {
        setHoldMoney();
        setCoins();
        setProducts();
        setInputMoney();
        while (IsStilChange()) {
            showResult();
        }
    }

    private void setHoldMoney() {
        OutputView.printRequestHoldMoney();
        int holdMoney = ExceptionHandler.input(inputView::readHoldMoney, 0);
        vendingMachine = VendingMachine.from(holdMoney, generator);
    }

    private void setCoins() {
    }

    private void setProducts() {

    }

    private void setInputMoney() {
    }

    private boolean IsStilChange() {
        return false;
    }

    private void showResult() {

    }
}
