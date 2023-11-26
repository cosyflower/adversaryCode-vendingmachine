package vendingmachine.product;

public class ProductName {
    private final String productNameValue;

    public ProductName(String productNameValue) {
        validateProductName(productNameValue);
        this.productNameValue = productNameValue;
    }

    private void validateProductName(String productNameValue) {
        // 2차 검증
    }

    public String getProductNameValue() {
        return productNameValue;
    }
}
