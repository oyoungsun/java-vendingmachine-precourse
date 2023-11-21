package vendingmachine;

import vendingmachine.view.InputView;

public class VendingMachineController {
    private final InputView inputView;

    public VendingMachineController(final InputView inputView) {
        this.inputView = inputView;
    }

    public void run(){
        setHoldMoney();
        setCoins();
        setProducts();
        setInputMoney();
        while(IsStilChange()) {
            showResult();
        }
    }

    private void setHoldMoney() {
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
