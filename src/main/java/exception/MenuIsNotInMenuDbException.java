package exception;

import util.ErrorMessage;

public class MenuIsNotInMenuDbException extends OrderException {
    public MenuIsNotInMenuDbException() {
        super(ErrorMessage.INCORRECT_ORDER.getMessage());
    }
}