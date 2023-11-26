package vendingmachine.domain;

import vendingmachine.domain.purchase.PurchaseProduct;
import vendingmachine.domain.vending.change.ChangeStatus;
import vendingmachine.domain.vending.product.RegisteredProduct;
import vendingmachine.domain.vending.product.VendingProducts;

public class VendingMachine {
    private final ChangeStatus changeStatus; // 잔돈 현황
    private final VendingProducts vendingProducts; // 판매하는 물품 (이름, 가격, 수량) 포함되어 있는 상황

    public VendingMachine(ChangeStatus changeStatus, VendingProducts vendingProducts) {
        this.changeStatus = changeStatus;
        this.vendingProducts = vendingProducts;
    }

    public boolean hasProduct(String purchaseProductValue) {
        return vendingProducts.isProductExisted(purchaseProductValue);
    }

    // 대기, 현 레벨 아닐 수도 있음
    // 판매된 상품을 차감한다 에서 사용된다. vendingProducts에서만 사용되는 방향으로 정리할 수 있음
    public RegisteredProduct findProduct(PurchaseProduct purchaseProduct) {
        return vendingProducts.findMatchedProduct(purchaseProduct);
    }
}
