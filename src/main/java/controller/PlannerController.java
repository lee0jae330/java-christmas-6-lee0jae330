package controller;

import domain.Discount;
import domain.MenuNameDb;
import domain.Order;
import domain.Price;
import domain.VisitDate;
import domain.repository.OrderRepository;

import exception.InvalidOrderFormatException;

import java.util.Arrays;
import java.util.List;

import util.ConstOfPlanner;
import util.Dessert;
import util.Drink;
import util.MainDish;


import validator.OrderInputFormatValidator;

import view.InputView;
import view.OutputView;

public class PlannerController {

    private final String GIVEAWAY_MENU = Drink.CHAMPAGNE.getMenu();
    private final int AMOUNT_OF_GIVEAWAY_MENU = ConstOfPlanner.AMOUNT_OF_GIVEAWAY_MENU.getNumber();

    public void run() {
        OutputView.printStartMessage();
        VisitDate visitDate = initVisitDate();
        OrderRepository orderRepository = initOrderRepository();
        printBenefitPreview(visitDate);
        printOrders(orderRepository);
        Price price = initPrice(orderRepository);
        printPriceBeforeDiscount(price);
        Discount discount = initDiscount(price,visitDate,orderRepository);
        printGiveawayMenu(discount, GIVEAWAY_MENU, AMOUNT_OF_GIVEAWAY_MENU);
        printBenefits(discount);
        printTotalBenefit(discount.calculateTotalDiscount());
        printPriceAfterDiscount(price,discount);
        printEventBadge(discount.getBadge());
    }

    private void printTotalBenefit(int amountOfBenefit) {
        OutputView.printTotalBenefit(amountOfBenefit);
    }

    private void printGiveawayMenu(Discount discount, String menu, int amount) {
        OutputView.printGiveawayMenu(discount.getGiveawayEvent(),menu,amount);
    }

    private void printEventBadge(String badge) {
        OutputView.printBadge(badge);
    }

    private void printPriceAfterDiscount(Price price, Discount discount) {
        calculatePriceAfterDiscount(price,discount);
        OutputView.printPriceAfterDiscount(price.getTotalPriceAfterDiscount());
    }

    private void calculatePriceAfterDiscount(Price price, Discount discount) {
        price.calculateTotalPriceAfterDiscount(discount.calculateRealDiscountAmount());
    }

    private void printBenefits(Discount discount) {
        int christmas = discount.getChristmasDday();
        int weekday = discount.getWeekday();
        int weekend = discount.getWeekend();
        int special = discount.getSpecial();
        int giveawayEvent = discount.getGiveawayEvent();
        OutputView.printAllBenefit(christmas, weekday, weekend, special, giveawayEvent);
    }

    private Discount adjustDiscount(Price price, VisitDate date, OrderRepository orders) {
        Discount discount = new Discount();
        String dessert = Dessert.CATEGORY.getMenu();
        String mainDish = MainDish.CATEGORY.getMenu();
        
        discount.adjustChristmasDdayDiscount(date.beforeChristmasDay(), date.getDate());
        discount.adjustWeekdayDiscount(date.isWeekday(), orders.numberOfCategoryMenu(dessert));
        discount.adjustWeekendDiscount(date.isWeekend(), orders.numberOfCategoryMenu(mainDish));
        discount.adjustSpecialDiscount(date.isSpecialDay());
        discount.adjustGiveawayEvent(price.getTotalPriceBeforeDiscount());
        discount.analyzeBadge();


        return discount;
    }

    private Discount initDiscount(Price price, VisitDate visitDate, OrderRepository orders) {
        if(!price.checkDiscoutEligibility()) {
            return new Discount();
        }
        return adjustDiscount(price, visitDate, orders);
    }

    private void printPriceBeforeDiscount(Price price) {
        OutputView.printPriceBeforeDiscount(price.getTotalPriceBeforeDiscount());
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
