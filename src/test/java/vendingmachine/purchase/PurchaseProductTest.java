package vendingmachine.purchase;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.PurchasingClient;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.purchase.PurchaseMoney;
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

    @Test
    void 예외2() {
        VendingMachine machine = VendingMachine.of(ChangeStatus.from(Change.from(500), new RandomNumberInRange()),
                VendingProducts.from(Arrays.asList(
                                RegisteredProduct.of(
                                        ProductName.from("신라면"),
                                        ProductPrice.from("1000"),
                                        ProductQuantity.from("10")),
                                RegisteredProduct.of(
                                        ProductName.from("진라면"),
                                        ProductPrice.from("1200"),
                                        ProductQuantity.from("0"))
                        )
                )
        );

        Assertions.assertThatCode(() -> PurchaseProduct.from("진라면", machine))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("품절된 상품입니다.");
    }

    @Test
    void toRegisteredProduct() {
        VendingMachine machine = VendingMachine.of(ChangeStatus.from(Change.from(500), new RandomNumberInRange()),
                VendingProducts.from(Arrays.asList(
                                RegisteredProduct.of(
                                        ProductName.from("신라면"),
                                        ProductPrice.from("1000"),
                                        ProductQuantity.from("10")),
                                RegisteredProduct.of(
                                        ProductName.from("진라면"),
                                        ProductPrice.from("1200"),
                                        ProductQuantity.from("0"))
                        )
                )
        );
        PurchaseProduct purchaseProduct = PurchaseProduct.from("신라면", machine);
        RegisteredProduct foundProduct = machine.findProductByName(purchaseProduct);
        Assertions.assertThat(foundProduct.getProductName()).isNotNull();
    }

    @Test
    void canBuyRegisteredProduct() {
        VendingMachine machine = VendingMachine.of(ChangeStatus.from(Change.from(500), new RandomNumberInRange()),
                VendingProducts.from(Arrays.asList(
                                RegisteredProduct.of(
                                        ProductName.from("신라면"),
                                        ProductPrice.from("1000"),
                                        ProductQuantity.from("10")),
                                RegisteredProduct.of(
                                        ProductName.from("진라면"),
                                        ProductPrice.from("1200"),
                                        ProductQuantity.from("0"))
                        )
                )
        );
        PurchaseProduct purchaseProduct = PurchaseProduct.from("신라면", machine);
        RegisteredProduct foundProduct = machine.findProductByName(purchaseProduct);

        Assertions.assertThatCode(() -> PurchasingClient.of(PurchaseMoney.from("800"), foundProduct))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("상품보다 적은 금액을 가지고 있습니다.");
    }
}
