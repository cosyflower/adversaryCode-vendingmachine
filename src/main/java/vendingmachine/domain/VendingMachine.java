package vendingmachine.domain;

import vendingmachine.domain.vending.change.ChangeStatus;
import vendingmachine.domain.vending.product.VendingProducts;

public class VendingMachine {
    private final ChangeStatus changeStatus; // 잔돈 금액으로 형성한 무작위 동전 모음
    private final VendingProducts vendingProducts; // 판매하는 상품들

    private VendingMachine(ChangeStatus changeStatus, VendingProducts vendingProducts) {
        this.changeStatus = changeStatus;
        this.vendingProducts = vendingProducts;
    }

    public static VendingMachine of(ChangeStatus changeStatus, VendingProducts vendingProducts) {
        return new VendingMachine(changeStatus, vendingProducts);
    }


    public boolean isUnvalidProduct(String purchaseProductValue) {
        return vendingProducts.isNotExistingProduct(purchaseProductValue);
    }

    public boolean isSoldOutProduct(String purchaseProductValue) {
        return vendingProducts.isSoldOut(purchaseProductValue);
    }
}
