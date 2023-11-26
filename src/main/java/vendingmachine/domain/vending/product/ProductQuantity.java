package vendingmachine.domain.vending.product;

import vendingmachine.exception.ProductException;

public class ProductQuantity {
    private final int productQuantityValue;

    private ProductQuantity(String productQuantityValue) {
        validateProductQuantity(productQuantityValue);
        this.productQuantityValue = Integer.parseInt(productQuantityValue);
    }

    public static ProductQuantity from(String productQuantityValue) {
        return new ProductQuantity(productQuantityValue);
    }

    private void validateProductQuantity(String productQuantityValue) {
        isStartsWithZero(productQuantityValue);
    }

    private void isStartsWithZero(String productQuantityValue) {
        if (productQuantityValue.startsWith("0") && productQuantityValue.length() > 1) {
            throw new ProductException("0으로 시작하는 수입니다.");
        }
    }

    public int getProductQuantityValue() {
        return productQuantityValue;
    }
}
