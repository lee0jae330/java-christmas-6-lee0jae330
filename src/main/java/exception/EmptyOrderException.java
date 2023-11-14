package exception;

import util.ErrorMessage;

public class EmptyOrderException extends OrderException {
    public EmptyOrderException() {
        super(ErrorMessage.INCORRECT_ORDER.getMessage());
    }
}
