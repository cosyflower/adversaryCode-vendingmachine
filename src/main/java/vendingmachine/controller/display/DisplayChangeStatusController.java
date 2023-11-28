package vendingmachine.controller.display;

import vendingmachine.domain.vending.change.Change;
import vendingmachine.domain.vending.change.ChangeStatus;
import vendingmachine.randomGenerator.RandomNumberInRange;
import vendingmachine.view.OutputView;

public class DisplayChangeStatusController {
    private final Change change;
    private final OutputView outputView;

    public DisplayChangeStatusController(Change change, OutputView outputView) {
        this.change = change;
        this.outputView = outputView;
    }

    public void process() {
        displayChangeStatus();
    }

    private void displayChangeStatus() {
        ChangeStatus changeStatus = ChangeStatus.from(change, new RandomNumberInRange());
        outputView.displayStatus(changeStatus);
    }
}
