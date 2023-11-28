package vendingmachine.controller;

import vendingmachine.ExceptionHandler;
import vendingmachine.domain.vending.change.Change;
import vendingmachine.request.ChangeRequest;
import vendingmachine.view.InputView;

public class RegisterChangeController {
    private final InputView inputView;

    public RegisterChangeController(InputView inputView) {
        this.inputView = inputView;
    }

    public Change process() {
        return ExceptionHandler.retryHandler(this::registerChange);
    }

    public Change registerChange() {
        ChangeRequest changeRequest = new ChangeRequest(inputView.inputChange());
        return changeRequest.toChange();
    }
}
