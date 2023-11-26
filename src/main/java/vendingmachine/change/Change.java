package vendingmachine.change;

public class Change {
    private final int changeValue;

    private Change(int changeValue) {
        this.changeValue = changeValue;
    }

    public static Change from(int changeValue) {
        return new Change(changeValue);
    }

    public int getChangeValue() {
        return changeValue;
    }
}
