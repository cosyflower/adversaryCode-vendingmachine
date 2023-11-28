package vendingmachine.view;

import java.util.Map;
import vendingmachine.domain.vending.Coin;
import vendingmachine.domain.vending.change.ChangeStatus;

public class OutputView {
    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    public void displayStatus(ChangeStatus changeStatus) {
        writer.print("자판기가 보유한 동전");
        displayEachCount(changeStatus);
    }

    private void displayEachCount(ChangeStatus changeStatus) {
        Map<Coin, Integer> status = changeStatus.getChangeStatus();
        for (Coin coin : status.keySet()) {
            System.out.printf(ResponseFormat.CHANGE_STATUS_FORMAT, coin.getAmount(), status.get(coin));
        }
    }
}
