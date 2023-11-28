package vendingmachine.system;

import java.util.Map;
import vendingmachine.domain.PurchasingClient;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.vending.Coin;
import vendingmachine.domain.vending.product.RegisteredProduct;

public class TradeManager {
    public static boolean isTradeAvailable(VendingMachine vendingMachine, PurchasingClient purchasingClient) {
        if (purchasingClient.hasNotEnoughMoney(vendingMachine)) {
            return false;
        }
        if (vendingMachine.isAllSoldOut()) {
            return false;
        }
        return true;
    }

    public static void trade(VendingMachine vendingMachine, PurchasingClient purchasingClient,
                             RegisteredProduct registeredProduct) {
        purchasingClient.payMoney(registeredProduct);
        vendingMachine.sellOneQuantity(registeredProduct);
    }

    public static Map<Coin, Integer> endWithChange(VendingMachine vendingMachine, PurchasingClient purchasingClient) {
        return vendingMachine.exchangeWithCoin(purchasingClient);
    }
}
