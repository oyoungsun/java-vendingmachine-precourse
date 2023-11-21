package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vendingmachine.Coin;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;

public class InputView {
    private static final String NUMBER_FORMAT = "정수의 범위가 아닙니다";
    private static final String BOUNDARY = "보유 금액은 0원 이상입니다";
    private static final String NOT_MONEY = "동전의 단위가 아닙니다";
    private static final String EMPTYSTRING = "문자열이 비어있습니다";
    private static final String NOT_PRODUCT_PATTERN = "상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분됩니다";
    private static final String PRODUCTS_SPLIT_DELIMITER = ";";
    private static final String PRODUCT_SPLIT_DELIMITER = ",";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String PRODUCT_REGEX = "\\"+PREFIX+"([^,]+),(\\d+),(\\d+)"+"\\"+SUFFIX; //TODO : [^,]+를 [,]제외한 모든 문자로
    private static final Pattern PRODUCT = Pattern.compile(PRODUCT_REGEX);

    public int readHoldMoney() {
        int input = readInt();
        if (input < 0) {
            throw new IllegalArgumentException(BOUNDARY);
        }
        if (input % Coin.COIN_10.getAmount() != 0) {
            throw new IllegalArgumentException(NOT_MONEY);
        }
        return input;
    }

    private int readInt() {
        String input = Console.readLine();
        return parseInt(input);
    }

    private int parseInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT);
        }
    }

    public Products readProducts() {
        String input = readString();
        List<String> inputSplited = Arrays.stream(
                input.split(PRODUCTS_SPLIT_DELIMITER)).toList();
        HashMap<Product, Integer> products = splitProduct(inputSplited);
        return Products.from(products);
    }

    private HashMap<Product, Integer> splitProduct(final List<String> inputSplited) {
        HashMap<Product, Integer> products = new HashMap<>();
        inputSplited.stream()
                .filter(item -> isProduct(item))
                .forEach(item -> convertProduct(products, item));
        return products;
    }

    private void convertProduct(final HashMap<Product, Integer> products, final String item) {

        String[] splited = item.replace(PREFIX, "")
                .replace(SUFFIX, "")
                .split(PRODUCT_SPLIT_DELIMITER);
        if (splited.length != 3) {
            throw new IllegalArgumentException(NOT_PRODUCT_PATTERN);
        }
        String name = splited[0];
        int price = parseInt(splited[1]);
        int count = parseInt(splited[2]);

        Product product = Product.from(name, price);
        products.put(product, count);
    }

    private boolean isProduct(String input) {
        Matcher matcher = PRODUCT.matcher(input);
        if (matcher.matches()) {
            return true;
        }
        throw new IllegalArgumentException(NOT_PRODUCT_PATTERN);
    }

    private String readString() {
        String input = Console.readLine();
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(EMPTYSTRING);
        }
        return input;
    }
}
