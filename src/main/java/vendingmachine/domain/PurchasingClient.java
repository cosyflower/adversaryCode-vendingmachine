package vendingmachine.domain;

import vendingmachine.domain.purchase.PurchaseMoney;
import vendingmachine.domain.purchase.PurchaseProduct;

public class PurchasingClient {
    private final PurchaseMoney purchaseMoney; // 투입한 금액
    private final PurchaseProduct purchaseProducts; // 사고자 하는 품목

    public PurchasingClient(PurchaseMoney purchaseMoney, PurchaseProduct purchaseProducts) {
        this.purchaseMoney = purchaseMoney;
        this.purchaseProducts = purchaseProducts;
    }
}
