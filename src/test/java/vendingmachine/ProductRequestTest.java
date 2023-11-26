package vendingmachine;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import vendingmachine.request.ProductRequest;

public class ProductRequestTest {
    @Nested
    class 성공 {
        @Test
        void flow() {
            Assertions.assertThatCode(() -> {
                new ProductRequest("[짜파게티,1000,1]");
                new ProductRequest("[짜파게티,1000,1];[자장면,2000,20]");
            }).doesNotThrowAnyException();
        }
    }

    @Nested
    class 예외 {
        @Test
        void flow() {
            Assertions.assertThatCode(() -> {
                        new ProductRequest("[짜파게티,1000 1]");
                        new ProductRequest("[짜파게티,1000,1][자장면,2000,20]");
                    }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }

    }
}
