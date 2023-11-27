package vendingmachine.purchase;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.purchase.PurchaseProduct;
import vendingmachine.domain.vending.change.Change;
import vendingmachine.domain.vending.change.ChangeStatus;
import vendingmachine.domain.vending.product.ProductName;
import vendingmachine.domain.vending.product.ProductPrice;
import vendingmachine.domain.vending.product.ProductQuantity;
import vendingmachine.domain.vending.product.RegisteredProduct;
import vendingmachine.domain.vending.product.VendingProducts;
import vendingmachine.randomGenerator.RandomNumberInRange;

public class PurchaseProductTest {
    @Test
    void 성공() {
        VendingMachine machine = VendingMachine.of(ChangeStatus.from(Change.from(500), new RandomNumberInRange()),
                VendingProducts.from(Arrays.asList(
                                RegisteredProduct.of(
                                        ProductName.from("신라면"),
                                        ProductPrice.from("1000"),
                                        ProductQuantity.from("10"))
                        )
                )
        );

        Assertions.assertThatCode(()-> PurchaseProduct.from("신라면", machine))
                .doesNotThrowAnyException();
    }

    @Test
    void 예외() {
        VendingMachine machine = VendingMachine.of(ChangeStatus.from(Change.from(500), new RandomNumberInRange()),
                VendingProducts.from(Arrays.asList(
                                RegisteredProduct.of(
                                        ProductName.from("신라면"),
                                        ProductPrice.from("1000"),
                                        ProductQuantity.from("10"))
                        )
                )
        );

        Assertions.assertThatCode(() -> PurchaseProduct.from("신라", machine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존재하지 않는 메뉴입니다.");

    }


}
