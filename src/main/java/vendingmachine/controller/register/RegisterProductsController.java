package vendingmachine.controller.register;

import vendingmachine.ExceptionHandler;
import vendingmachine.domain.vending.product.VendingProducts;
import vendingmachine.request.ProductRequest;
import vendingmachine.view.InputView;

public class RegisterProductsController {
    private final InputView inputView;

    public RegisterProductsController(InputView inputView) {
        this.inputView = inputView;
    }

    public VendingProducts process() {
        return ExceptionHandler.retryHandler(this::registerProducts);
    }

    private VendingProducts registerProducts() {
        ProductRequest productRequest = new ProductRequest(inputView.inputProducts());
        return productRequest.toVendingProducts();
    }
}
