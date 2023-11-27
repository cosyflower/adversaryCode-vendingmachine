package vendingmachine.domain;

import vendingmachine.domain.purchase.PurchaseMoney;
import vendingmachine.domain.vending.product.RegisteredProduct;
import vendingmachine.exception.VendingMachineException;

public class PurchasingClient {
    private PurchaseMoney purchaseMoney;

    private PurchasingClient(PurchaseMoney purchaseMoney,
                            RegisteredProduct registeredProduct) {
        this.purchaseMoney = purchaseMoney;
        validatePurchasingClient(registeredProduct);
    }

    public static PurchasingClient of(PurchaseMoney purchaseMoney, RegisteredProduct registeredProduct) {
        return new PurchasingClient(purchaseMoney, registeredProduct);
    }

    // 금액이나 상품 변경시 계속 호출해야 한다 (updateClient)
    private void validatePurchasingClient(RegisteredProduct registeredProduct) {
        if (purchaseMoney.isMoreThan(registeredProduct.getProductPriceValue())) {
            return;
        }
        throw new VendingMachineException("상품보다 적은 금액을 가지고 있습니다.");
    }

    public boolean hasNotEnoughMoney(VendingMachine vendingMachine) {
        int minimumPrice = vendingMachine.findMinimumPrice();
        if (purchaseMoney.isMoreThan(minimumPrice)) {
            return false;
        }
        return true;
    }

    public void payMoney(RegisteredProduct registeredProduct) {
        purchaseMoney = purchaseMoney.adjustPrice(registeredProduct.getProductPrice());
    }

    public PurchaseMoney getPurchaseMoney() {
        return purchaseMoney;
    }
}
