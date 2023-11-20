package exception;

public abstract class OrderException extends IllegalArgumentException {
    public OrderException(String message) {
        super(message);
    }
}
