package validator;

import exception.InvalidOrderFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderInputFormatValidator {

    private static final String REGEX = ",{2,}";

    public static void checkOrderInputFormatValidator(String input) {
        findConsecutiveCommas(input);
        checkOrderStartWithComma(input);
    }

    private static void checkOrderEndWithComma(String input) {
        if (input.charAt(input.length()-1) == ',') {
            throw new InvalidOrderFormatException();
        }
    }

    private static void checkOrderStartWithComma(String input) {
        if (input.charAt(0) == ',') {
            throw new InvalidOrderFormatException();
        }
    }

    private static void findConsecutiveCommas(String input) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new InvalidOrderFormatException();
        }
    }
}
