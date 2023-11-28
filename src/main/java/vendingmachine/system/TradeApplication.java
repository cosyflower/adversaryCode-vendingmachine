package vendingmachine.system;

import vendingmachine.controller.register.RegisterChangeController;
import vendingmachine.controller.display.DisplayChangeStatusController;
import vendingmachine.controller.register.RegisterProductsController;
import vendingmachine.controller.register.RegisterPurchaseMoneyController;
import vendingmachine.domain.purchase.PurchaseMoney;
import vendingmachine.domain.vending.change.Change;
import vendingmachine.domain.vending.product.VendingProducts;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class TradeApplication {
    private final InputView inputView;
    private final OutputView outputView;

    public TradeApplication(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Change change = new RegisterChangeController(inputView).process();
        new DisplayChangeStatusController(change, outputView).process();

        VendingProducts vendingProducts = new RegisterProductsController(inputView).process(); // 상품 등록

        PurchaseMoney purchaseMoney = new RegisterPurchaseMoneyController(inputView).process(); // 투입 금액 등록
    }
}
