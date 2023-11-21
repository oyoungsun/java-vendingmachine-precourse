package vendingmachine;

import vendingmachine.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        VendingMachineController controller = new VendingMachineController(inputView);
    }
}
