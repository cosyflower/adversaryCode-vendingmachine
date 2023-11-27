package vendingmachine.request;

import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.purchase.PurchaseProduct;
import vendingmachine.exception.ProductException;
import vendingmachine.parser.RequestRegex;

public class PurchaseProductRequest {
    private final String purchaseProductRequestInput;

    public PurchaseProductRequest(String purchaseProductRequestInput) {
        validatePurchaseProductRequestInput(purchaseProductRequestInput);
        this.purchaseProductRequestInput = purchaseProductRequestInput;
    }

    public PurchaseProduct toPurChaseProduct(VendingMachine vendingMachine) {
        return PurchaseProduct.from(purchaseProductRequestInput, vendingMachine);
    }

    private void validatePurchaseProductRequestInput(String purchaseProductRequestInput) {
        isNullOrEmpty(purchaseProductRequestInput);
        hasProductPattern(purchaseProductRequestInput);
    }

    private void isNullOrEmpty(String purchaseProductRequestInput) {
        if (purchaseProductRequestInput == null || purchaseProductRequestInput.isEmpty()) {
            throw new ProductException("아무것도 입력하지 않았습니다.");
        }
    }

    private void hasProductPattern(String purchaseProductRequestInput) {
        if (RequestRegex.PRODUCT_PATTERN.matcher(purchaseProductRequestInput).matches()) {
            return;
        }
        throw new ProductException("상품 형식에 맞지 않는 입력입니다.");
    }
}
