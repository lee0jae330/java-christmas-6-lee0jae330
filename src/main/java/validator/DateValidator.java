package validator;

import exception.InvalidDateFormatException;
import exception.OutOfDateRangeException;

import util.ConstOfPlanner;
import util.ErrorMessage;

public class DateValidator {

    private final int minOfDate = ConstOfPlanner.MIN_OF_DATE.getNumber();
    private final int maxOfDate = ConstOfPlanner.MAX_OF_DATE.getNumber();

    public int checkDateValidation(String input) {
        int date = checkDateContainOnlyNumber(input);
        checkRangeOfDate(date);
        return date;
    }

    public void checkRangeOfDate(int date) {
        if(date < minOfDate || date > maxOfDate) {
            throw new OutOfDateRangeException();
        }
    }

    private int checkDateContainOnlyNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidDateFormatException();
        }
    }
}
