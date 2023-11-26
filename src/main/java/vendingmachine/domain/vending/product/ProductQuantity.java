package vendingmachine.product;

public class ProductQuantity {
    private final int productQuantityValue;

    public ProductQuantity(int productQuantityValue) {
        validateProductQuantity(productQuantityValue);
        this.productQuantityValue = productQuantityValue;
    }

    private void validateProductQuantity(int productQuantityValue) {
        // 2차 검증
        // 0 으로 시작하지 않는지 확인한다

    }

    public int getProductQuantityValue() {
        return productQuantityValue;
    }
}
