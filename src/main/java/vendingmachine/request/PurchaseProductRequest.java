package vendingmachine.request;

import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.purchase.PurchaseProduct;
import vendingmachine.exception.ProductException;
import vendingmachine.parser.RequestRegex;

public class PurchaseProductRequest {
    private final String purchaseProduct;

    public PurchaseProductRequest(String purchaseProduct) {
        validatePurchaseProduct(purchaseProduct);
        this.purchaseProduct = purchaseProduct;
    }

    public static PurchaseProduct toPurchaseProduct(String purchaseProduct, VendingMachine vendingMachine) {
        return PurchaseProduct.of(purchaseProduct, vendingMachine);
    }

    private void validatePurchaseProduct(String purchaseProduct) {
        isNullOrEmpty(purchaseProduct);
        hasProductPattern(purchaseProduct);
    }

    private void isNullOrEmpty(String purchaseProduct) {
        if (purchaseProduct == null || purchaseProduct.isEmpty()) {
            throw new ProductException("아무것도 입력하지 않았습니다");
        }
    }

    private void hasProductPattern(String purchaseProduct) {
        if (RequestRegex.PRODUCT_PATTERN.matcher(purchaseProduct).matches()) {
            return;
        }
        throw new ProductException("상품 정보를 잘못 입력했습니다.");
    }
}
