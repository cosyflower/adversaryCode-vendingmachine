package vendingmachine.product;

public class ProductPrice {
    private final int productPriceValue;

    public ProductPrice(int productPriceValue) {
        validateProductPrice(productPriceValue);
        this.productPriceValue = productPriceValue;
    }

    private void validateProductPrice(int productPriceValue) {
        // 2차 검증
        // 0으로 시작하지 않는지 확인하기
        // 10원 단위로 구성되어 있는지 확인
        // 100원 보다 크고, 최대 범위보다는 작은지 확ㅇ니하기
    }

    public int getProductPriceValue() {
        return productPriceValue;
    }
}
