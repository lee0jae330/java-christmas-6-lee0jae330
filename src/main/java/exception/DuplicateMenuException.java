package exception;

import util.ErrorMessage;

public class DuplicateMenuException extends OrderException {
    public DuplicateMenuException() {
        super(ErrorMessage.INCORRECT_ORDER.getMessage());
    }
}
