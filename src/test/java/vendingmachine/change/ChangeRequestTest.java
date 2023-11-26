package vendingmachine.change;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import vendingmachine.request.ChangeRequest;

public class ChangeRequestTest {
    @Nested
    class 변환전_성공 {
        @Test
        void flow() {
            assertThatCode(() -> new ChangeRequest("3000"))
                    .doesNotThrowAnyException();
        }

        @Test
        void flow2() {
            assertThatCode(() -> new ChangeRequest("0"))
                    .doesNotThrowAnyException();
        }

    }

    @Nested
    class 변환후_성공 {
        @Test
        void flow() {
            assertThatCode(() -> new ChangeRequest("3000").toChange())
                    .doesNotThrowAnyException();
        }

        @Test
        void flow2() {
            assertThatCode(() -> new ChangeRequest("0").toChange())
                    .doesNotThrowAnyException();
        }

    }

    @Nested
    class 변환전_예외 {
        @Test
        void 숫자를_입력하지_않으면_예외() {
            assertThatCode(() -> new ChangeRequest("숫자가 아님"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

    @Nested
    class 변환후_예외 {
        @Test
        void 잔돈이_10원_단위가_아니라면_예외() {
            assertThatCode(() -> new ChangeRequest("01"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }
}
