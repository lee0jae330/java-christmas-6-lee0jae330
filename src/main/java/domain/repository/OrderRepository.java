package domain.repository;

import domain.Order;

import exception.DuplicateMenuException;
import exception.OutOfOrderNumberRangeException;

import java.util.HashSet;
import java.util.Set;

import util.ConstOfPlanner;

public class OrderRepository {
    Set<Order> orders;

    public OrderRepository() {
        this.orders = new HashSet<>();
    }

    public void saveOrder(Order order) {
        checkDuplicateMenu(order);
        orders.add(order);
        checkAllMenuQuantityRange();
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
