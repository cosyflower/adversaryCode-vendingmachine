package vendingmachine.domain.vending.product;

public class ProductName {
    private final String productNameValue;

    private ProductName(String productNameValue) {
        this.productNameValue = productNameValue;
    }

    public static ProductName from(String productNameValue) {
        return new ProductName(productNameValue);
    }
    public String getProductNameValue() {
        return productNameValue;
    }

    public boolean hasSameName(String purchaseProductValue) {
        return productNameValue.equals(purchaseProductValue);
    }
}
