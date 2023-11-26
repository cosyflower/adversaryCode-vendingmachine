package vendingmachine.request;

public class ProductRequest {
    private final String productRequestInput;

    public ProductRequest(String productRequestInput) {
        validateProductRequest(productRequestInput);
        this.productRequestInput = productRequestInput;
    }

    private void validateProductRequest(String productRequestInput) {
        // 1차 검증
        // isNullOrEmpty()
        // 문자로 구성되어 있는지 확인
        // 형식에 맞게 작성되었는지를 확인한다 [  ,  , ];[  ,  ,  ] 형태인지를 확인한다
    }
}
