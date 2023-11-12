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
