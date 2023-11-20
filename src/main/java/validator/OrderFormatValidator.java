package validator;

import exception.InvalidOrderFormatException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderFormatValidator {

    private static final String REGEX = "-{2,}";

    public static List<String> checkOrderFormat(String input) {
        findConsecutiveHyphen(input);
        checkInputEndWithHyphen(input);
        checkInputStartWithHyphen(input);
        return checkNumberOfParsedInput(input);
    }

    private static List<String> checkNumberOfParsedInput(String input) {
        List<String> parsedInput = Arrays.asList(input.split("-"));
        if(parsedInput.size()!=2) {
            throw new InvalidOrderFormatException();
        }
        return parsedInput;
    }

    private static void checkInputEndWithHyphen(String input) {
        if(input.charAt(input.length()-1) == '-') {
            throw new InvalidOrderFormatException();
        }
    }

    private static void checkInputStartWithHyphen(String input) {
        if(input.charAt(0) == '-') {
            throw new InvalidOrderFormatException();
        }
    }

    private static void findConsecutiveHyphen(String input) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            throw new InvalidOrderFormatException();
        }
    }
}
