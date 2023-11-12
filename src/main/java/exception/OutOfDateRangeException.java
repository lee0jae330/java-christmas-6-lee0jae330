package exception;

import util.ErrorMessage;

public class OutOfDateRangeException extends DateException {
    public OutOfDateRangeException() {
        super(ErrorMessage.INCORRECT_DATE.getMessage());
    }
}