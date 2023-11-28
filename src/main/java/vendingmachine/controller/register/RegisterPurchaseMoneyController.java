package vendingmachine.controller.register;

import vendingmachine.ExceptionHandler;
import vendingmachine.domain.purchase.PurchaseMoney;
import vendingmachine.request.PurchaseMoneyRequest;
import vendingmachine.view.InputView;

public class RegisterPurchaseMoneyController {
    private final InputView inputView;

    public RegisterPurchaseMoneyController(InputView inputView) {
        this.inputView = inputView;
    }

    public PurchaseMoney process() {
        return ExceptionHandler.retryHandler(this::registerPurchaseMoney);
    }

    private PurchaseMoney registerPurchaseMoney() {
        PurchaseMoneyRequest purchaseMoneyRequest = new PurchaseMoneyRequest(inputView.inputPurchaseMoney());
        return purchaseMoneyRequest.toPurchaseMoney();
    }
}
