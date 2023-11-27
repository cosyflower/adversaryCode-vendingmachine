package vendingmachine.purchase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import vendingmachine.request.PurchaseProductRequest;

public class PurchaseProductRequestTest {
    @Test
    void 성공() {
        Assertions.assertThatCode(() -> new PurchaseProductRequest("자파게티"))
                .doesNotThrowAnyException();
    }
}
