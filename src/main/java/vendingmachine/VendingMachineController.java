package vendingmachine;

import java.util.Map;
import vendingmachine.d.HoldCoinDto;
import vendingmachine.domain.Products;
import vendingmachine.service.PurchaseService;
import vendingmachine.utils.ExceptionHandler;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final InputView inputView;
    private final CoinGenerator generator;
    private VendingMachine vendingMachine;
    private PurchaseService purchaseService;

    public VendingMachineController(final InputView inputView, final CoinGenerator generator) {
        this.inputView = inputView;
        this.generator = generator;

    }

    public void run() {
        setHoldMoney();
        setCoins();
        Products products = setProducts();
        int inputMoney = setInputMoney();
        purchaseService = PurchaseService.from(products, inputMoney);
        while (IsStilChange()) {
            showResult();
        }
    }

    private void setHoldMoney() {
        OutputView.printRequestHoldMoney();
        int holdMoney = ExceptionHandler.input(inputView::readMoney, 0);
        vendingMachine = VendingMachine.from(holdMoney, generator);
    }

    private void setCoins() {
        Map<Coin, Integer> coins = vendingMachine.getCoins();
        HoldCoinDto coinDto = HoldCoinDto.from(coins);
        OutputView.printHoldCoin(coinDto);
    }

    private Products setProducts() {
        OutputView.printRequestProducts();
        return ExceptionHandler.input(inputView::readProducts, 0);
    }

    private Integer setInputMoney() {
        OutputView.printRequestInputMoney();
        return ExceptionHandler.input(inputView::readMoney, 0);
    }

    private boolean IsStilChange() {
        return false;
    }

    private void showResult() {

    }
}
