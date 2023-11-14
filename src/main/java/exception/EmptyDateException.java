package exception;

import util.ErrorMessage;

public class EmptyDateException extends DateException {
    public EmptyDateException() {
        super(ErrorMessage.INCORRECT_DATE.getMessage());
    }
}
