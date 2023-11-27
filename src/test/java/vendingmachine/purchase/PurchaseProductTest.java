package vendingmachine.purchase;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.vending.change.Change;
import vendingmachine.domain.vending.change.ChangeStatus;
import vendingmachine.domain.vending.product.ProductName;
import vendingmachine.domain.vending.product.ProductPrice;
import vendingmachine.domain.vending.product.ProductQuantity;
import vendingmachine.domain.vending.product.RegisteredProduct;
import vendingmachine.domain.vending.product.VendingProducts;
import vendingmachine.randomGenerator.RandomNumberInRange;
import vendingmachine.request.PurchaseProductRequest;

public class PurchaseProductTest {
    @Test
    void 성공() {
        ChangeStatus changeStatus = ChangeStatus.from(Change.from(500), new RandomNumberInRange());
        VendingProducts vending = VendingProducts.from(Arrays.asList(
                RegisteredProduct.of(ProductName.from("짜파게티"),
                        ProductPrice.from("1000"),
                        ProductQuantity.from("10"))
                )
        );

        VendingMachine vendingMachine = VendingMachine.of(changeStatus, vending);

        Assertions.assertThatCode(()-> new PurchaseProductRequest("짜파게티").toPurchaseProduct(vendingMachine))
                .doesNotThrowAnyException();
    }

    @Test
    void 예외() {
        ChangeStatus changeStatus = ChangeStatus.from(Change.from(500), new RandomNumberInRange());
        VendingProducts vending = VendingProducts.from(Arrays.asList(
                        RegisteredProduct.of(ProductName.from("짜파"),
                                ProductPrice.from("1000"),
                                ProductQuantity.from("10"))
                )
        );

        VendingMachine vendingMachine = VendingMachine.of(changeStatus, vending);

        Assertions.assertThatCode(() -> new PurchaseProductRequest("짜파게티").toPurchaseProduct(vendingMachine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


}
