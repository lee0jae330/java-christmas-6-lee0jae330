package validator;

import exception.InvalidDateFormatException;
import exception.OutOfDateRangeException;

import util.ConstOfPlanner;

public class DateValidator {

    private static final int minOfDate = ConstOfPlanner.MIN_OF_DATE.getNumber();
    private static final int maxOfDate = ConstOfPlanner.MAX_OF_DATE.getNumber();

    public static int checkDateValidation(String input) {
        int date = checkDateContainOnlyNumber(input);
        checkRangeOfDate(date);
        return date;
    }

    public static void checkRangeOfDate(int date) {
        if(date < minOfDate || date > maxOfDate) {
            throw new OutOfDateRangeException();
        }
    }

    private static int checkDateContainOnlyNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidDateFormatException();
        }
    }
}
