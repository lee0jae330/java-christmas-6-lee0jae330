package domain;

import java.util.List;

import validator.MenuNameValidator;
import validator.OrderFormatValidator;
import validator.QuantityValidator;

public class Order {
    private String menu;
    private int price;
    private int quantity;
    private String category;

    public Order (String input) {
        List<String> order = OrderFormatValidator.checkOrderFormat(input);
        setMenu(order.get(0));
        setQuantity(order.get(1));
    }

    public String getMenu() {
        return menu;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private void setMenu(String menuName) {
        MenuNameValidator.checkMenuNameValidation(menuName);
        this.menu = menuName;
    }
    
    private void setQuantity(String number) {
        this.quantity = QuantityValidator.checkQuantityValidation(number);
    }

}
