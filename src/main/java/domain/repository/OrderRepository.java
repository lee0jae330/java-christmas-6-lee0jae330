package domain.repository;

import domain.Order;

import exception.AllMenuAreDrinkException;
import exception.DuplicateMenuException;
import exception.OutOfOrderNumberRangeException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import util.ConstOfPlanner;
import util.Dessert;
import util.Drink;
import util.MainDish;

public class OrderRepository {
    private final Set<Order> orders;

    public OrderRepository() {
        this.orders = new HashSet<>();
    }

    public void saveOrder(Order order) {
        checkDuplicateMenu(order);
        orders.add(order);
        checkAllMenuQuantityRange();
    }

    public int numberOfCategoryMenu(String category) {
        int count = 0;
        for(Order order : orders) {
            if(order.isEqualCategory(category)) {
                count++;
            }
        }
        return count;
    }

    public Map<String,Integer> getMenuInformation() {
        Map<String,Integer> menuInformation = new HashMap<>();
        for(Order o : orders) {
            menuInformation.put(o.getMenu(),o.getQuantity());
        }
        return menuInformation;
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for(Order order : orders) {
            totalPrice += order.getPrice() * order.getQuantity();
        }
        return totalPrice;
    }

    public void checkAllMenuAreDrink() {
        for(Order order : orders) {
            if(!order.getCategory().equals(Drink.CATEGORY.getMenu())) {
                return;
            }
        }
        throw new AllMenuAreDrinkException();
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
