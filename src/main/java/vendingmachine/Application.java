package vendingmachine;

import vendingmachine.domain.CoinGenerator;
import vendingmachine.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        CoinGenerator generator = new CoinGenerator();
        VendingMachineController controller = new VendingMachineController(inputView, generator);
        controller.run();
    }
}
