package controller;

import domain.MenuNameDb;
import domain.Order;
import domain.Price;
import domain.VisitDate;
import domain.repository.OrderRepository;

import exception.InvalidOrderFormatException;

import java.util.Arrays;
import java.util.List;

import validator.OrderInputFormatValidator;

import view.InputView;
import view.OutputView;

public class PlannerController {

    public void run() {
        OutputView.printStartMessage();
        VisitDate visitDate = initVisitDate();
        OrderRepository orderRepository = initOrderRepository();
        printBenefitPreview(visitDate);
        printOrders(orderRepository);
        Price price = initPrice(orderRepository);
    }

    private Price initPrice(OrderRepository orderRepository) {
        return new Price(orderRepository.calculateTotalPrice());
    }

    private void printBenefitPreview(VisitDate visitDate) {
        OutputView.printBenefitPreview(visitDate.getDate());
    }

    private void printOrders(OrderRepository orderRepository) {
        OutputView.printOrders(orderRepository.getMenuInformation());
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
        try {
            String input = InputView.enterOrder();
            return parsedOrder(input);
        } catch (InvalidOrderFormatException e) {
            OutputView.printError(e.getMessage());
            return initOrder();
        }
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
