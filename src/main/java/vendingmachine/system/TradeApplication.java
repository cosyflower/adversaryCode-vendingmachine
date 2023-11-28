package vendingmachine.system;

import vendingmachine.controller.register.RegisterChangeController;
import vendingmachine.controller.display.DisplayChangeStatusController;
import vendingmachine.domain.vending.change.Change;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class TradeApplication {
    private final InputView inputView;
    private final OutputView outputView;

    public TradeApplication(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Change change = new RegisterChangeController(inputView).process();
        new DisplayChangeStatusController(change, outputView).process();
    }
}
