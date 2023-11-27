package vendingmachine.domain;

import java.util.Map;
import vendingmachine.domain.purchase.PurchaseMoney;
import vendingmachine.domain.purchase.PurchaseProduct;
import vendingmachine.domain.vending.Coin;
import vendingmachine.domain.vending.change.ChangeStatus;
import vendingmachine.domain.vending.product.RegisteredProduct;
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

    // PurchaseProduct -> search - Registeredproduct - Client field 등록
    public RegisteredProduct findProductByName(PurchaseProduct purchaseProduct) {
        return vendingProducts.searchProductByName(purchaseProduct);
    }

    public boolean isAllSoldOut() {
        return vendingProducts.isNothing();
    }

    public int findMinimumPrice() {
        return vendingProducts.findCheapestPrice();
    }

    public void sellOneQuantity(PurchasingClient purchasingClient) {
        vendingProducts.sellSpecificProduct(purchasingClient);
    }

    public Map<Coin, Integer> exchangeWithCoin(PurchasingClient purchasingClient) {
        // 남은 금액 확인
        PurchaseMoney remainedMoneyForChange = purchasingClient.getPurchaseMoney();
        return changeStatus.checkChange(remainedMoneyForChange);
    }

    public ChangeStatus getChangeStatus() {
        return changeStatus;
    }
}
