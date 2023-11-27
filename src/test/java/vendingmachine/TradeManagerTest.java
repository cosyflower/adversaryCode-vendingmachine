package vendingmachine;

import java.util.Arrays;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.PurchasingClient;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.purchase.PurchaseMoney;
import vendingmachine.domain.purchase.PurchaseProduct;
import vendingmachine.domain.vending.Coin;
import vendingmachine.domain.vending.change.Change;
import vendingmachine.domain.vending.change.ChangeStatus;
import vendingmachine.domain.vending.product.ProductName;
import vendingmachine.domain.vending.product.ProductPrice;
import vendingmachine.domain.vending.product.ProductQuantity;
import vendingmachine.domain.vending.product.RegisteredProduct;
import vendingmachine.domain.vending.product.VendingProducts;
import vendingmachine.randomGenerator.RandomNumberInRange;
import vendingmachine.request.PurchaseProductRequest;

public class TradeManagerTest {
    @Test
    void 성공() {
        VendingMachine machine = VendingMachine.of(ChangeStatus.from(Change.from(500), new RandomNumberInRange()),
                VendingProducts.from(Arrays.asList(
                                RegisteredProduct.of(
                                        ProductName.from("신라면"),
                                        ProductPrice.from("1000"),
                                        ProductQuantity.from("10")),
                                RegisteredProduct.of(
                                        ProductName.from("진라면"),
                                        ProductPrice.from("1200"),
                                        ProductQuantity.from("1"))
                        )
                )
        );

        PurchaseProduct purchaseProduct =
                new PurchaseProductRequest("진라면").toPurChaseProduct(machine);

        RegisteredProduct foundProduct = machine.findProductByName(purchaseProduct);

        PurchasingClient client = PurchasingClient.of(PurchaseMoney.from("2000"), foundProduct);

        boolean tradeAvailable = TradeManager.isTradeAvailable(machine, client);
        Assertions.assertThat(tradeAvailable).isEqualTo(true);
    }

    @Test
    void trade() {
        VendingMachine machine = VendingMachine.of(ChangeStatus.from(Change.from(500), new RandomNumberInRange()),
                VendingProducts.from(Arrays.asList(
                                RegisteredProduct.of(
                                        ProductName.from("신라면"),
                                        ProductPrice.from("1000"),
                                        ProductQuantity.from("10")),
                                RegisteredProduct.of(
                                        ProductName.from("진라면"),
                                        ProductPrice.from("1200"),
                                        ProductQuantity.from("1"))
                        )
                )
        );

        PurchaseProduct purchaseProduct =
                new PurchaseProductRequest("진라면").toPurChaseProduct(machine);
        RegisteredProduct foundProduct = machine.findProductByName(purchaseProduct); // 찾고
        PurchasingClient client = PurchasingClient.of(PurchaseMoney.from("2000"), foundProduct); // Client 구성

        TradeManager.trade(machine, client, foundProduct);

        PurchaseMoney clientMoney = client.getPurchaseMoney();
        int purchaseMoneyValue = clientMoney.getPurchaseMoneyValue();

        System.out.println("purchaseMoneyValue = " + purchaseMoneyValue); // 800

        boolean JINSOLDOUT = machine.isSoldOutProduct("진라면"); // True
        boolean SHINSOLDOUT = machine.isSoldOutProduct("신라면"); // False

    }

    @Test
    void endWithChange() {
        VendingMachine machine = VendingMachine.of(ChangeStatus.from(Change.from(1000), new RandomNumberInRange()),
                VendingProducts.from(Arrays.asList(
                                RegisteredProduct.of(
                                        ProductName.from("신라면"),
                                        ProductPrice.from("1000"),
                                        ProductQuantity.from("10")),
                                RegisteredProduct.of(
                                        ProductName.from("진라면"),
                                        ProductPrice.from("1200"),
                                        ProductQuantity.from("1"))
                        )
                )
        );

        PurchaseProduct purchaseProduct =
                new PurchaseProductRequest("신라면").toPurChaseProduct(machine);
        RegisteredProduct foundProduct = machine.findProductByName(purchaseProduct); // 찾고
        PurchasingClient client = PurchasingClient.of(PurchaseMoney.from("2000"), foundProduct); // Client 구성

        TradeManager.trade(machine, client, foundProduct);
        Map<Coin, Integer> coinIntegerMap = TradeManager.endWithChange(machine, client);

        for (Coin coin : coinIntegerMap.keySet()) {
            System.out.println("coin = " + coin);
            System.out.println("coinIntegerMap.get(coin) = " + coinIntegerMap.get(coin));
        }
    }
}
