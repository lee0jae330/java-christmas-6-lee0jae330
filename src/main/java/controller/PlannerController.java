package controller;

import domain.MenuNameDB;
import domain.VisitDate;

import view.InputView;
import view.OutputView;

public class PlannerController {

    public void run() {
        MenuNameDB menuNameDB = initMenuDB();
        OutputView.printStartMessage();
        VisitDate visitDate = initVisitDate();

    }
    private VisitDate initVisitDate() {
        try {
            VisitDate visitDate = new VisitDate(InputView.enterDate());
            return visitDate;
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
