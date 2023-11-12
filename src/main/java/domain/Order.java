package domain;

import java.util.List;

import validator.MenuNameValidator;
import validator.OrderFormatValidator;
import validator.QuantityValidator;

public class Order {
    private String menu;
    private int quantity;

    public Order (String input) {
        List<String> order = OrderFormatValidator.checkOrderFormat(input);
        setMenu(order.get(0));
        setQuantity(order.get(1));
    }

    private void setMenu(String menuName) {
        MenuNameValidator.checkMenuNameValidation(menuName);
        this.menu = menu;
    }
    
    private void setQuantity(String number) {
        this.quantity = QuantityValidator.checkQuantityValidation(number);
    }

}
