package exception;

import util.ErrorMessage;

public class InvalidDateFormatException extends DateException {
    public InvalidDateFormatException() {
        super(ErrorMessage.INCORRECT_DATE.getMessage());
    }
}