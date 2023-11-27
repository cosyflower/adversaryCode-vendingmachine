package vendingmachine.domain.purchase;

import vendingmachine.domain.vending.product.ProductPrice;
import vendingmachine.exception.StartsWithZeroException;

public class PurchaseMoney {
    private final int purchaseMoneyValue;

    private PurchaseMoney(String purchaseMoneyValue) {
        validatePurchaseMoney(purchaseMoneyValue);
        this.purchaseMoneyValue = Integer.parseInt(purchaseMoneyValue);
    }

    private void validatePurchaseMoney(String purchaseMoneyValue) {
        if (purchaseMoneyValue.startsWith("0") && purchaseMoneyValue.length() > 1) {
            throw new StartsWithZeroException("0으로 시작하는 수를 입력했습니다");
        }
    }

    public static PurchaseMoney from(String purchaseMoneyValue) {
        return new PurchaseMoney(purchaseMoneyValue);
    }

    public boolean isMoreThan(int miminumPrice) {
        return purchaseMoneyValue >= miminumPrice;
    }

    public PurchaseMoney adjustPrice(ProductPrice foundProductPrice) {
        return PurchaseMoney.from(String.valueOf(purchaseMoneyValue - foundProductPrice.getProductPriceValue()));
    }
}
