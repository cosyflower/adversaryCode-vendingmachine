package vendingmachine.purchase;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import vendingmachine.exception.ProductException;
import vendingmachine.request.PurchaseProductRequest;

public class PurchaseProductRequestTest {
    @Test
    void 성공() {
        Assertions.assertThatCode(() -> new PurchaseProductRequest("짜파게티"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 실패(String nothingInput) {
        Assertions.assertThatCode(() -> new PurchaseProductRequest(nothingInput))
                .isInstanceOf(ProductException.class)
                .hasMessageContaining("[ERROR]");
    }
}
