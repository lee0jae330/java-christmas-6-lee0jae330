package controller;

import exception.InvalidDateFormatException;
import validator.OrderInputFormatValidator;
import domain.MenuNameDB;
import domain.VisitDate;

import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PlannerController {

    public void run() {
        MenuNameDB menuNameDB = initMenuDB();
        OutputView.printStartMessage();
        VisitDate visitDate = initVisitDate();

    }
    private List<String> parsedOrder(String input) {
        try {
            OrderInputFormatValidator.checkOrderInputFormatValidator(input);
            return Arrays.asList(input.split(","));
        } catch (InvalidDateFormatException e) {
            return enterOrder();
        }

    }

    private List<String> enterOrder() {
        String input = InputView.enterOrder();
        return parsedOrder(input);
    }
    private void initOrderRepository() {
        List<String> orders = enterOrder();


    }

    private VisitDate initVisitDate() {
        try {
            return new VisitDate(InputView.enterDate());
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return initVisitDate();
        }
    }

    private MenuNameDB initMenuDB() {
        MenuNameDB menuNameDB = new MenuNameDB();
        menuNameDB.initDB();
        return menuNameDB;
    }
}
