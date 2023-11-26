package vendingmachine.randomGenerator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumberInRange implements RandomNumberGenerator {
    @Override
    public int generateRandomNumberInRange(List<Integer> numberRange) {
        return Randoms.pickNumberInList(numberRange);
    }
}
