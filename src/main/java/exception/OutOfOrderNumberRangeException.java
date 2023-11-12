package exception;

import util.ErrorMessage;

public class OutOfOrderNumberRangeException extends OrderException {
    public OutOfOrderNumberRangeException() {
        super(ErrorMessage.INCORRECT_ORDER.getMessage());
    }
}
