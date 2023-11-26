package vendingmachine.change;

import vendingmachine.exception.ChangeException;

public class Change {
    private final int changeValue;

    private Change(int changeValue) {
        validateChange(changeValue);
        this.changeValue = changeValue;
    }

    private void validateChange(int changeValue) {
        canDivideWithMinimumUnit(changeValue); // 10으로 나눌 수 있는지
    }

    private void canDivideWithMinimumUnit(int changeValue) {
        if (changeValue % 10 == 0) {
            return;
        }
        throw new ChangeException("10원 단위의 잔돈 금액을 입력하지 않았습니다.");
    }

    public static Change from(int changeValue) {
        return new Change(changeValue);
    }

    public int getChangeValue() {
        return changeValue;
    }
}
