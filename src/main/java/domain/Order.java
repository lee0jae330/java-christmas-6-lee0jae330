package domain;

import java.util.List;

import validator.OrderFormatValidator;

public class Order {
    private String menu;
    private int quantity;

    public Order (String input) {
        List<String> order = OrderFormatValidator.checkOrderFormat(input);
    }

    private void setMenu(String menu) {
        this.menu = menu;
    }
    
    private void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
