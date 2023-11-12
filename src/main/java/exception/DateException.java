package exception;

public abstract class DateException extends IllegalArgumentException {
    public DateException(String message) {
        super(message);
    }
}