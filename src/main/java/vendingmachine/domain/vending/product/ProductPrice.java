package vendingmachine.domain.vending.product;

import vendingmachine.exception.ProductException;

public class ProductPrice {
    private final int productPriceValue;

    private ProductPrice(String productPriceValue) {
        validateProductPrice(productPriceValue);
        this.productPriceValue = Integer.parseInt(productPriceValue);
    }

    public static ProductPrice from(String productPriceValue) {
        return new ProductPrice(productPriceValue);
    }

    private void validateProductPrice(String productPriceValue) {
        isStartsWithZero(productPriceValue);
        canDividedByUnit(productPriceValue);
        isInRange(productPriceValue);
    }

    private void isStartsWithZero(String productPriceValue) {
        if (productPriceValue.startsWith("0") && productPriceValue.length() > 1) {
            throw new ProductException("0으로 시작한 수입니다.");
        }
    }

    private void canDividedByUnit(String productPriceValue) {
        int parsedValue = Integer.parseInt(productPriceValue);
        if (parsedValue % 10 == 0) {
            return;
        }
        throw new ProductException("10원 단위의 가격이 아닙니다.");
    }

    private void isInRange(String productPriceValue) {
        int parsedValue = Integer.parseInt(productPriceValue);
        if (parsedValue < 100 || parsedValue > Integer.MAX_VALUE) {
            throw new ProductException("범위에서 벗어난 가격을 입력했습니다");
        }
    }

    public int getProductPriceValue() {
        return productPriceValue;
    }
}
