package vendingmachine.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import vendingmachine.request.ProductRequest;

public class RegisteredProductTest {
    @Nested
    class 성공 {
        @Test
        void 해결() {
            Assertions.assertThatCode(() -> {
                new ProductRequest("[짜파게티,1000,1]").toVendingProducts();
                new ProductRequest("[짜파게티,1000,1];[자장면,2000,20]").toVendingProducts();
            }).doesNotThrowAnyException();
        }
    }

    @Nested
    class 실패 {
        @Test
        void 예외() {
            Assertions.assertThatCode(() -> {
                        new ProductRequest("[짜파게티,1000,1];").toVendingProducts();
                        new ProductRequest("[짜파게티,1000,1]=[자장면,2000,20]").toVendingProducts();
                        new ProductRequest("[짜파게티,1000,1];[짜파게티,2000,20]").toVendingProducts();
                }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }

    }

}
