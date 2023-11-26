package vendingmachine;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import vendingmachine.randomGenerator.RandomNumberGenerator;

public class ChangeStatus {
    private static final int INIT_VALUE = 0;
    private final Map<Coin, Integer> changeStatus;

    private ChangeStatus(int changeInput, RandomNumberGenerator randomNumberGenerator) {
        changeStatus = new EnumMap<Coin, Integer>(Coin.class);
        initChangeStatus();
        setChangeStatus(changeInput, randomNumberGenerator);
    }

    public static ChangeStatus from(int changeInput, RandomNumberGenerator randomNumberGenerator) {
        return new ChangeStatus(changeInput, randomNumberGenerator);
    }

    private void initChangeStatus() {
        Arrays.stream(Coin.values())
                .forEach(coin -> changeStatus.put(coin, INIT_VALUE));
    }

    private void setChangeStatus(int changeInput, RandomNumberGenerator randomNumberGenerator) {
        for (Coin coin : Coin.values()) {
            int pickedNumber = randomNumberGenerator.generateRandomNumberInRange(
                    generateNumberRange(coin, changeInput));
            changeStatus.replace(coin, pickedNumber);
            changeInput -= pickedNumber * coin.getAmount();
        }
        checkRest(changeInput);
    }

    private void checkRest(int changeInput) {
        if (changeInput > 0) {
            int restChange = changeInput / Coin.COIN_10.getAmount();
            Integer restAmount = changeStatus.get(Coin.COIN_10);
            changeStatus.put(Coin.COIN_10, restAmount + restChange);
        }
    }

    private List<Integer> generateNumberRange(Coin coin, int changeInput) {
        return IntStream.range(0, changeInput / coin.getAmount() + 1)
                .mapToObj(num -> num)
                .collect(Collectors.toList());
    }

    public Map<Coin, Integer> getChangeStatus() {
        return changeStatus;
    }
}
