package vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.vending.Coin;
import vendingmachine.domain.vending.change.Change;
import vendingmachine.domain.vending.change.ChangeStatus;
import vendingmachine.randomGenerator.RandomNumberInRange;

public class ChangeStatusTest {
    @ParameterizedTest
    @ValueSource(ints = {450, 500, 10, 0})
    void 랜덤으로_생성한_잔돈_총액_검증(int input) {
        ChangeStatus status = ChangeStatus.from(Change.from(input), new RandomNumberInRange());

        Map<Coin, Integer> changeStatus = status.getChangeStatus();

        int sum = changeStatus.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getAmount() * entry.getValue())
                .sum();

        assertThat(sum).isEqualTo(input);
    }
}
