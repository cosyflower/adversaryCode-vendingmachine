package vendingmachine.purchase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.exception.VendingMachineException;
import vendingmachine.request.PurchaseMoneyRequest;

public class PurchaseMoneyTest {
    @Test
    void 성공() {
        Assertions.assertThatCode(() -> new PurchaseMoneyRequest("0").toPurchaseMoney())
                .doesNotThrowAnyException();
    }

    @Test
    void 실패() {
        Assertions.assertThatCode(() -> new PurchaseMoneyRequest("01").toPurchaseMoney())
                .isInstanceOf(VendingMachineException.class)
                .hasMessageContaining("[ERROR]");
    }
}
