package vendingmachine.request;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.domain.vending.product.ProductName;
import vendingmachine.domain.vending.product.ProductPrice;
import vendingmachine.domain.vending.product.ProductQuantity;
import vendingmachine.domain.vending.product.RegisteredProduct;
import vendingmachine.domain.vending.product.VendingProducts;
import vendingmachine.exception.ProductException;
import vendingmachine.parser.RequestRegex;

public class ProductRequest {
    private final String productRequestInput;

    public ProductRequest(String productRequestInput) {
        validateProductRequest(productRequestInput);
        this.productRequestInput = productRequestInput;
    }

    public VendingProducts toVendingProducts() {
        String[] splitInput = productRequestInput.split(";");
        List<RegisteredProduct> convertedProduct = Arrays.stream(splitInput)
                .map(split -> toRegisteredProduct(split))
                .collect(Collectors.toList());
        return VendingProducts.from(convertedProduct);
    }

    private RegisteredProduct toRegisteredProduct(String splitProductRequestInput) {
        splitProductRequestInput = splitProductRequestInput.substring(1, splitProductRequestInput.length() - 1);

        String[] splitInput = splitProductRequestInput.split(",");
        String productNameValue = splitInput[0];
        String productPriceValue = splitInput[1];
        String productQuantityValue = splitInput[2];
        return RegisteredProduct.of(ProductName.from(productNameValue), ProductPrice.from(productPriceValue),
                ProductQuantity.from(productQuantityValue));
    }

    private void validateProductRequest(String productRequestInput) {
        isNullOrEmpty(productRequestInput);
        hasProductPattern(productRequestInput);
    }

    private void isNullOrEmpty(String productRequestInput) {
        if (productRequestInput == null || productRequestInput.isEmpty()) {
            throw new ProductException("아무것도 입력하지 않았습니다.");
        }
    }

    private void hasProductPattern(String productRequestInput) {
        if (RequestRegex.ORDER_PATTERN.matcher(productRequestInput).matches()) {
            return;
        }
        throw new ProductException("형식에 맞게 입력하지 않았습니다");
    }

}
