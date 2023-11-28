package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements Reader {
    @Override
    public String input() {
        return Console.readLine();
    }
}
