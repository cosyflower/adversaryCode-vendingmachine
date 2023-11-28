package vendingmachine;

import vendingmachine.view.ConsoleReader;
import vendingmachine.view.ConsoleWriter;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        TradeApplication tradeApplication = new TradeApplication(
                new InputView(new ConsoleWriter(), new ConsoleReader()),
                new OutputView(new ConsoleWriter()));
        tradeApplication.run();
    }
}
