package vendingmachine.request;

import vendingmachine.domain.purchase.PurchaseMoney;
import vendingmachine.exception.VendingMachineException;
import vendingmachine.parser.RequestRegex;

public class PurchaseMoneyRequest {
    private final String purchaseMoneyRequest;

    public PurchaseMoneyRequest(String purchaseMoneyRequest) {
        validatePurchaseMoneyRequest(purchaseMoneyRequest);
        this.purchaseMoneyRequest = purchaseMoneyRequest;
    }

    public PurchaseMoney toPurchaseMoney() {
        return PurchaseMoney.from(purchaseMoneyRequest);
    }

    private void validatePurchaseMoneyRequest(String purchaseMoneyRequest) {
        isNullOrEmpty(purchaseMoneyRequest);
        hasNumberPattern(purchaseMoneyRequest);
    }



    private void isNullOrEmpty(String purchaseMoneyRequest) {
        if (purchaseMoneyRequest == null || purchaseMoneyRequest.isEmpty()) {
            throw new VendingMachineException("아무것도 입력하지 않았습니다.");
        }
    }

    private void hasNumberPattern(String purchaseMoneyRequest) {
        if (RequestRegex.NUMBER_PATTERN.matcher(purchaseMoneyRequest).matches()) {
            return;
        }
        throw new VendingMachineException("수를 입력하지 않았습니다.");
    }

}
