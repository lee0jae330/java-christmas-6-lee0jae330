package validator;

import exception.OutOfDateRangeException;
import exception.QuantityNumberFormatException;
import util.ConstOfPlanner;

public class QuantityValidator {

    public static int checkQuantityValidation(String number) {
        int quantity = checkQuantityIsNumber(number);
        checKQuantityRange(quantity);
        return quantity;
    }

    private static void checKQuantityRange(int quantity) {
        if(quantity < ConstOfPlanner.MIN_NUM_OF_ORDER.getNumber() || quantity > ConstOfPlanner.MAX_NUM_OF_ORDER.getNumber()) {
            throw new OutOfDateRangeException();
        }   
    }

    private static int checkQuantityIsNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new QuantityNumberFormatException();
        }
    }
}
