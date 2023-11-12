package exception;

import util.ErrorMessage;

public class InvalidOrderFormatException extends OrderException {
    public InvalidOrderFormatException() {
        super(ErrorMessage.INCORRECT_DATE.getMessage());
    }
}
