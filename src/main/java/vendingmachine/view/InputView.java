package vendingmachine.view;

public class InputView {
    // Reader - Interface ConsoleReader 로 변경하기
    // Writer - Interface ConsoleWriter 로 변경 하기
    private final Writer writer;
    private final Reader reader;

    public InputView(Writer writer, Reader reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public String inputChange() {
        printMessage("자판기가 보유하고 있는 금액을 입력해 주세요.");
        return readInput();
    }

    private String readInput() {
        return reader.input();
    }

    private void printMessage(String message) {
        writer.print(message);
    }
}
