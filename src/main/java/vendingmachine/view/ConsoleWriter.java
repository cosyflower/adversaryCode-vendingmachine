package vendingmachine.view;

import java.util.Map;
import vendingmachine.domain.vending.Coin;
import vendingmachine.domain.vending.change.ChangeStatus;

public class ConsoleWriter implements Writer {



    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printFormat(String regex, Object... values) {
        System.out.printf(regex, values);
    }
}
