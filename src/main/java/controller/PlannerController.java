package controller;

import domain.MenuNameDb;
import domain.Order;
import domain.VisitDate;
import domain.repository.OrderRepository;

import exception.InvalidDateFormatException;
import exception.InvalidOrderFormatException;
import validator.OrderInputFormatValidator;

import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PlannerController {

    public void run() {
        OutputView.printStartMessage();
        VisitDate visitDate = initVisitDate();
        OrderRepository orderRepository = initOrderRepository();
    }
    private List<String> parsedOrder(String input) {
        try {
            OrderInputFormatValidator.checkOrderInputFormatValidator(input);
            return Arrays.asList(input.split(","));
        } catch (InvalidOrderFormatException e) {
            return initOrder();
        }

    }

    private List<String> initOrder() {
        String input = InputView.enterOrder();
        return parsedOrder(input);
    }

    private OrderRepository initOrderRepository() {
        OrderRepository orderRepository = new OrderRepository();
        MenuNameDb menuNameDb = new MenuNameDb();
        List<String> orders = initOrder();
        try{
            for(String orderString : orders) {
                Order order = new Order(orderString);
                order.setCategory(menuNameDb.findCategory(order.getMenu()));
                order.setPrice(menuNameDb.getPrice(order.getMenu()));
            }
        } catch (IllegalArgumentException e) {
            return initOrderRepository();
        }
        return orderRepository;
    }

    private VisitDate initVisitDate() {
        try {
            return new VisitDate(InputView.enterDate());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return initVisitDate();
        }
    }
}
