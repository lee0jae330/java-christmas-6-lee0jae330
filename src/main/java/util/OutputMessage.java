package util;

public enum OutputMessage {
    PROGRAM_START_MSG(12,"안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.");
    private final int month;
    private final String message;

    OutputMessage(int month, String message) {
        this.month = month;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
