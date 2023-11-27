package vendingmachine.domain.vending.product;

public class RegisteredProduct implements Comparable<RegisteredProduct> {
    private final ProductName productName;
    private final ProductPrice productPrice;
    private ProductQuantity productQuantity;

    private RegisteredProduct(ProductName productName, ProductPrice productPrice,
                             ProductQuantity productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public static RegisteredProduct of(ProductName productName, ProductPrice productPrice,
                                       ProductQuantity productQuantity) {
        return new RegisteredProduct(productName, productPrice, productQuantity);
    }

    public boolean hasProduct(String purchaseProductValue) {
        return productName.hasSameNameValue(purchaseProductValue);
    }

    public boolean hasMinimumQuantity() {
        if (productQuantity.isZero()) {
            return false;
        }
        return true;
    }

    public boolean hasSameName(String purchaseProductValue) {
        return productName.hasSameNameValue(purchaseProductValue);
    }

    @Override
    public int compareTo(RegisteredProduct o) {
        return this.productPrice.getProductPriceValue() - o.productPrice.getProductPriceValue();
    }

    public ProductName getProductName() {
        return productName;
    }

    public int getProductPriceValue() {
        return productPrice.getProductPriceValue();
    }
}
