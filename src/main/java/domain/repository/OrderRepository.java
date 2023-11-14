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

    private void checkDuplicateMenu(Order order) {
        for(Order o : orders) {
            if(o.getMenu().equals(order.getMenu())) {
                throw new DuplicateMenuException();
            }
        }
    }
}
