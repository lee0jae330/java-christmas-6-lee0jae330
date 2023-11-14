package domain.repository;

import domain.Order;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {
    Map <Order,Integer> orders;

    public OrderRepository() {
        this.orders = new HashMap<>();
    }

    public void saveOrder(Order order) {

    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for(Order order : orders) {
            totalPrice += order.getPrice() * order.getQuantity();
        }
        return totalPrice;
    }

    private void checkDuplicateMenu(Order order) {
        for(Order o : orders) {
            if(o.getMenu().equals(order.getMenu())) {
                throw new DuplicateMenuException();
            }
        }
    }

    private int calculateAllMenusQuantity() {
        int totalQuantity = 0;
        for(Order order :  orders) {
            totalQuantity += order.getQuantity();
        }
        return totalQuantity;
    }

    private void checkAllMenuQuantityRange() {
        if(calculateAllMenusQuantity() > ConstOfPlanner.MAX_NUM_OF_ORDER.getNumber()) {
            throw new OutOfOrderNumberRangeException();
        }
    }
}
