package exception;

import util.ErrorMessage;

public class AllMenuAreDrinkException extends OrderException {
    public AllMenuAreDrinkException() {
        super(ErrorMessage.INCORRECT_ORDER.getMessage());
    }
}
