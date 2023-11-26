package vendingmachine.request;

import vendingmachine.domain.vending.change.Change;
import vendingmachine.exception.ChangeException;
import vendingmachine.parser.RequestRegex;

public class ChangeRequest {
    private final String changeRequestInput;

    public ChangeRequest(String changeRequestInput) {
        validateChangeRequest(changeRequestInput);
        this.changeRequestInput = changeRequestInput;
    }

    public Change toChange() {
        return Change.from(Integer.parseInt(changeRequestInput));
    }

    private void validateChangeRequest(String changeRequestInput) {
        isStartingWithZero(changeRequestInput);
        isNullOrEmpty(changeRequestInput);
        hasNumberPattern(changeRequestInput);
    }

    private void isStartingWithZero(String changeRequestInput) {
        if (changeRequestInput.startsWith("0") && changeRequestInput.length() > 1) {
            throw new ChangeException("0으로 시작하는 수는 0원만 입력 가능합니다.");
        }
    }

    private void isNullOrEmpty(String changeRequestInput) {
        if (changeRequestInput == null || changeRequestInput.isEmpty()) {
            throw new ChangeException("아무것도 입력하지 않았습니다.");
        }
    }

    private void hasNumberPattern(String changeRequestInput) {
        if (RequestRegex.NUMBER_PATTERN.matcher(changeRequestInput).matches()) {
            return;
        }
        throw new ChangeException("수를 입력하지 않았습니다.");
    }


}
