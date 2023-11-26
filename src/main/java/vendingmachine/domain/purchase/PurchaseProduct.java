package vendingmachine.domain.purchase;

import vendingmachine.domain.VendingMachine;
import vendingmachine.exception.VendingMachineException;

public class PurchaseProduct {
    private final String purchaseProductName;

    private PurchaseProduct(String purchaseProductName, VendingMachine vendingMachine) {
        validatePurchaseProduct(purchaseProductName, vendingMachine);
        this.purchaseProductName = purchaseProductName;
    }

    public static PurchaseProduct of(String purchaseProductName, VendingMachine vendingMachine) {
        return new PurchaseProduct(purchaseProductName, vendingMachine);
    }

    private void validatePurchaseProduct(String purchaseProductName, VendingMachine vendingMachine) {
        if (vendingMachine.hasProduct(purchaseProductName)) {
            return;
        }
        throw new VendingMachineException("존재하지 않는 상품입니다.");
    }

    public String getPurchaseProductName() {
        return purchaseProductName;
    }
}
