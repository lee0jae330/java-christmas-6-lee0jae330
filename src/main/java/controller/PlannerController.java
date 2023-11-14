package controller;

import domain.MenuNameDb;
import domain.Order;
import domain.VisitDate;
import domain.repository.OrderRepository;

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
            OutputView.printError(e.getMessage());
            return initOrder();
        }

    }

    private List<String> initOrder() {
        String input = InputView.enterOrder();
        return parsedOrder(input);
    }

    private OrderRepository processOrder(List<String> orders) {
        OrderRepository orderRepository = new OrderRepository();
        MenuNameDb menuNameDb = new MenuNameDb();
        for(String order : orders) {
            Order newOrder = new Order(order);
            newOrder.setCategory(menuNameDb.findCategory(newOrder.getMenu()));
            newOrder.setPrice(menuNameDb.getPrice(newOrder.getMenu()));
            orderRepository.saveOrder(newOrder);
        }
        orderRepository.checkAllMenuAreDrink();
        return orderRepository;
    }

    private OrderRepository initOrderRepository() {
        List<String> orders = initOrder();
        try{
            return processOrder(orders);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return initOrderRepository();
        }
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
