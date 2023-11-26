package vendingmachine.parser;

import java.util.regex.Pattern;

public class RequestRegex {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    public static final Pattern ORDER_PATTERN =
            Pattern.compile(("(\\[[ㄱ-ㅎ가-힣]+,\\d+,\\d+\\])+(;\\[[ㄱ-ㅎ가-힣]+,\\d+,\\d+\\])*"));
    public static final Pattern PRODUCT_PATTERN = Pattern.compile("^[ㄱ-ㅎ가-힣]+$");
}
