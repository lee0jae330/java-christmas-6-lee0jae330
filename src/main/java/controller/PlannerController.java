package controller;

import controller.validator.DateValidator;

import domain.VisitDate;

import view.InputView;
import view.OutputView;

public class PlannerController {

    private final DateValidator dateValidator = new DateValidator();
    private VisitDate visitDate;

    public void run() {
        OutputView.printStartMessage();
        initDate();
    }

    private void initDate() {
        String input = InputView.enterDate();
        checkDateValidation(input);
    }

    private void checkDateValidation(String input) {
        try {
            int date = dateValidator.checkDateValidation(input);
            visitDate = new VisitDate(date);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            initDate();
        }
    }
}
