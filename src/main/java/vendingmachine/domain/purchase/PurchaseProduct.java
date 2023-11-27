package vendingmachine.domain.purchase;

import vendingmachine.domain.VendingMachine;
import vendingmachine.exception.ProductException;

public class PurchaseProduct {
    private final String purchaseProductValue;

    private PurchaseProduct(String purchaseProductValue, VendingMachine vendingMachine) {
        canPurchase(purchaseProductValue, vendingMachine);
        this.purchaseProductValue = purchaseProductValue;
    }

    public static PurchaseProduct from(String purchaseProductValue, VendingMachine vendingMachine) {
        return new PurchaseProduct(purchaseProductValue, vendingMachine);
    }

    private void canPurchase(String purchaseProductValue, VendingMachine vendingMachine) {
        if (vendingMachine.isUnvalidProduct(purchaseProductValue)) {
            throw new ProductException("존재하지 않는 메뉴입니다.");
        }
        if (vendingMachine.isSoldOutProduct(purchaseProductValue)) {
            throw new ProductException("품절된 상품입니다.");
        }
    }
}
