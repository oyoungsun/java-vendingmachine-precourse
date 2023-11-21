package vendingmachine;

import java.util.HashMap;
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
        Map<Coin, Integer> coins = vendingMachine.getCoins();
        HoldCoinDto coinDto = HoldCoinDto.from(coins);
        OutputView.printHoldCoin(coinDto);
    }

    private void setProducts() {
        OutputView.printRequestProducts();
        Products products = ExceptionHandler.input(inputView::readProducts, 0);
        purchaseService = PurchaseService.from(products);
    }

    private void setInputMoney() {

    }

    private boolean IsStilChange() {
        return false;
    }

    private void showResult() {

    }
}
