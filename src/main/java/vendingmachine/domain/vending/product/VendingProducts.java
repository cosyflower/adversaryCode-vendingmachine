package vendingmachine.product;

import java.util.ArrayList;
import java.util.List;

public class VendingProducts {
    // 실제로 관리하는 상품들
    private final List<RegisteredProduct> vendingProducts;

    public VendingProducts(List<RegisteredProduct> vendingProducts) {
        // 중복된 이름인지 검증해야 한다
        validateVendingProducts(vendingProducts);
        this.vendingProducts = new ArrayList<>(vendingProducts);
    }

    private void validateVendingProducts(List<RegisteredProduct> vendingProducts) {
        hasDuplicatedName(vendingProducts);
    }

    private void hasDuplicatedName(List<RegisteredProduct> vendingProducts) {

    }


}
