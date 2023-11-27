package vendingmachine.domain.vending.product;

public class ProductName {
    private final String productNameValue;

    private ProductName(String productNameValue) {
        this.productNameValue = productNameValue;
    }

    public static ProductName from(String productNameValue) {
        return new ProductName(productNameValue);
    }

    public boolean hasSameNameValue(String purchaseProductValue) {
        return productNameValue.equals(purchaseProductValue);
    }
}
