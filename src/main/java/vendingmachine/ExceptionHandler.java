package vendingmachine;

import java.util.function.Supplier;

public class ExceptionHandler {
    public static <T> T retryHandler(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retryHandler(supplier);
        }
    }
}
