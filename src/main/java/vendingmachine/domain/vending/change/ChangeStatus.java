package vendingmachine.domain.vending.change;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import vendingmachine.domain.vending.Coin;
import vendingmachine.randomGenerator.RandomNumberGenerator;

public class ChangeStatus {
    private static final int INIT_VALUE = 0;
    private final Map<Coin, Integer> changeStatus;

    private ChangeStatus(Change change, RandomNumberGenerator randomNumberGenerator) {
        changeStatus = new EnumMap<Coin, Integer>(Coin.class);
        initChangeStatus();
        setChangeStatus(change, randomNumberGenerator);
    }

    public static ChangeStatus from(Change change, RandomNumberGenerator randomNumberGenerator) {
        return new ChangeStatus(change, randomNumberGenerator);
    }

    private void initChangeStatus() {
        Arrays.stream(Coin.values())
                .forEach(coin -> changeStatus.put(coin, INIT_VALUE));
    }

    private void setChangeStatus(Change change, RandomNumberGenerator randomNumberGenerator) {
        for (Coin coin : Coin.values()) {
            int pickedNumber = randomNumberGenerator.generateRandomNumberInRange(
                    generateNumberRange(coin, change));
            changeStatus.replace(coin, pickedNumber);
            change = change.adjustPrice(pickedNumber * coin.getAmount());
        }
        checkRest(change);
    }

    private void checkRest(Change change) {
        int changeValue = change.getChangeValue();
        if (changeValue > 0) {
            int restChange = changeValue / Coin.COIN_10.getAmount();
            Integer restAmount = changeStatus.get(Coin.COIN_10);
            changeStatus.put(Coin.COIN_10, restAmount + restChange);
        }
    }

    private List<Integer> generateNumberRange(Coin coin, Change change) {
        return IntStream.range(0, change.getChangeValue() / coin.getAmount() + 1)
                .mapToObj(num -> num)
                .collect(Collectors.toList());
    }

    public Map<Coin, Integer> getChangeStatus() {
        return changeStatus;
    }
}
