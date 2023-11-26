package vendingmachine.request;

public class ChangeRequest {
    private final String changeRequestInput;

    public ChangeRequest(String changeRequestInput) {
        validateChangeRequest(changeRequestInput);
        this.changeRequestInput = changeRequestInput;
    }

    private void validateChangeRequest(String changeRequestInput) {
        // 1차 검증을 진행한다
    }


}
