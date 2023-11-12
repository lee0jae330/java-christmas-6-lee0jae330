package domain;

import java.util.List;

import validator.OrderFormatValidator;

public class Order {
    private String menu;
    private int quantity;

    public Order (String input) {
        List<String> order = OrderFormatValidator.checkOrderFormat(input);
    }

}
