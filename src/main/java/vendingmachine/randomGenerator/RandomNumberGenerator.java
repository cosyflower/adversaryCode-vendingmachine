package vendingmachine.randomGenerator;

import java.util.List;

public interface RandomNumberGenerator {
    int generateRandomNumberInRange(List<Integer> numberRange);
}
