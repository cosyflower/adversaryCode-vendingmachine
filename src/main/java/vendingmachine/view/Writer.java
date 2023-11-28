package vendingmachine.view;

public interface Writer {
    void print(String message);
    void printFormat(String regex, Object... values);
}
