package util;

public enum OutputMessage {
    PROGRAM_START_MSG("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.");
    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage(int month) {
        return String.format(message,month);
    }
}
