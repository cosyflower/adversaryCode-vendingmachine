package vendingmachine.purchase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.exception.VendingMachineException;
import vendingmachine.request.PurchaseMoneyRequest;

public class PurchaseMoneyRequestTest {
    @Test
    void flow() {
        Assertions.assertThatCode(() -> new PurchaseMoneyRequest("01"))
                .doesNotThrowAnyException();
    }

    @Test
    void error() {
        Assertions.assertThatCode(() -> new PurchaseMoneyRequest("숫자가 아님"))
                .isInstanceOf(VendingMachineException.class)
                .hasMessageContaining("[ERROR]");
    }
}
