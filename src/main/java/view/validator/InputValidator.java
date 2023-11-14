package view.validator;

import exception.InvalidDateFormatException;
import exception.InvalidOrderFormatException;


public class InputValidator {
    public String checkDateValidation(String input) {
        checkDateIsEmpty(input);
        return input;
    }

    public String checkOrderValidation(String input) {
        checkOrderIsEmpty(input);
        return input;
    }

    private void checkOrderIsEmpty(String input) {
        if(input.isEmpty()) {
            throw new InvalidOrderFormatException();
        }
    }

    private void checkDateIsEmpty(String input) {
        if(input.isEmpty()) {
            throw new InvalidDateFormatException();
        }
    }
}
