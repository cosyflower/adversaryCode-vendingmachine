package vendingmachine.exception;

public class VendingMachineException extends IllegalArgumentException {
    private static final String ERROR_PREFIX = "[ERROR]";
    public VendingMachineException(String errorMessage) {
        super(ERROR_PREFIX + errorMessage);
    }
}
