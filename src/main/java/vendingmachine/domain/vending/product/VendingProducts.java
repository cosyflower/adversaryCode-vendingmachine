package vendingmachine.domain.vending.product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.domain.purchase.PurchaseProduct;
import vendingmachine.exception.ProductException;

public class VendingProducts {
    // 실제로 관리하는 상품들
    private final List<RegisteredProduct> vendingProducts;

    private VendingProducts(List<RegisteredProduct> vendingProducts) {
        validateVendingProducts(vendingProducts);
        this.vendingProducts = new ArrayList<>(vendingProducts);
    }

    public static VendingProducts from(List<RegisteredProduct> convertedProduct) {
        return new VendingProducts(convertedProduct);
    }

    private void validateVendingProducts(List<RegisteredProduct> vendingProducts) {
        hasDuplicatedName(vendingProducts);
    }

    private void hasDuplicatedName(List<RegisteredProduct> vendingProducts) {
        List<ProductName> productNames = vendingProducts.stream()
                .map(RegisteredProduct::getProductName)
                .collect(Collectors.toList());

        if (vendingProducts.size() == productNames.stream().distinct().count()) {
            return;
        }
        throw new ProductException("중복된 상품을 입력했습니다.");
    }


    public boolean isProductExisted(String purchaseProductNameValue) {
        return vendingProducts.stream()
                .filter(vendingProduct -> vendingProduct.hasProduct(purchaseProductNameValue)) // 추출하기
                .findAny().isPresent();
    }

    public RegisteredProduct findMatchedProduct(PurchaseProduct purchaseProduct) {
        return vendingProducts.stream()
                .filter(registeredProduct ->
                        registeredProduct.hasProduct(purchaseProduct.getPurchaseProductName())) // 추출하기
                .findFirst()
                .get();
    }
}
