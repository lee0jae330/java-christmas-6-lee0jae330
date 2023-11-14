package util;

public enum ErrorMessage {
    INCORRECT_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INCORRECT_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요.");
    
    private static final String ERROR = "[ERROR]";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + " " + message;
    }
}