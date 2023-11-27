package vendingmachine.exception;

import vendingmachine.exception.VendingMachineException;

public class StartsWithZeroException extends VendingMachineException {

    public StartsWithZeroException(String errorMessage) {
        super(errorMessage);
    }
}
