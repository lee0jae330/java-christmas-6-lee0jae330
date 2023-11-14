package domain;

import validator.DateValidator;

public class VisitDate {
    private int date;
    private final DateValidator dateValidator = new DateValidator();

    public VisitDate(String input) {
        this.date = dateValidator.checkDateValidation(input);
    }

    public int getDate() {
        return date;
    }
}
