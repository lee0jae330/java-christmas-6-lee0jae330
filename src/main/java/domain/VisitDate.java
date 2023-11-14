package domain;

import validator.DateValidator;

public class VisitDate {
    private int date;

    public VisitDate(String input) {
        this.date = DateValidator.checkDateValidation(input);
    }

    public int getDate() {
        return date;
    }
}
