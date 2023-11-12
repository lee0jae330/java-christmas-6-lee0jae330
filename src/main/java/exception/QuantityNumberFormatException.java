package exception;

import util.ErrorMessage;

public class QuantityNumberFormatException extends OrderException {
    public QuantityNumberFormatException() {
        super(ErrorMessage.INCORRECT_ORDER.getMessage());
    }
}
