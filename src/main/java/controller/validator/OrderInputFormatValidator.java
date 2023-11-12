package controller.validator;

import exception.InvalidOrderFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderInputFormatValidator {

    private final String REGEX = ",{2,}";

    public void checkOrderInputFormatValidator(String input) {
        findConsecutiveCommas(input);
        checkOrderStartWithComma(input);
    }

    private void checkOrderEndWithComma(String input) {
        if (input.charAt(input.length()-1) == ',') {
            throw new InvalidOrderFormatException();
        }
    }

    private void checkOrderStartWithComma(String input) {
        if (input.charAt(0) == ',') {
            throw new InvalidOrderFormatException();
        }
    }

    private void findConsecutiveCommas(String input) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new InvalidOrderFormatException();
        }
    }
}
