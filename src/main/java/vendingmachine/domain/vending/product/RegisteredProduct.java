package vendingmachine.product;

public class RegisteredProduct {
    private final ProductName productName;
    private final ProductPrice productPrice;
    private final ProductQuantity productQuantity;

    public RegisteredProduct(ProductName productName, ProductPrice productPrice,
                             ProductQuantity productQuantity) {
        // 검증은 각각의 클래스 내에서 진행한다 -> 다시 말해, 이 구간에서는 검증할 이유가 없음
        // 검증하지 않아도 된다
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public ProductName getProductName() {
        return productName;
    }

    public ProductPrice getProductPrice() {
        return productPrice;
    }

    public ProductQuantity getProductQuantity() {
        return productQuantity;
    }
}
