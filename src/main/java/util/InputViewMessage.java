package util;

public enum InpuviewMessage {
    PROGRAM_START_MSG("안녕하세요! 우테코 식당 12월 이벤트 플레너입니다."),
    ENTER_DATE("12월 중 식당 예상 방문날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ENTER_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1))");

    private final String message;

    InpuviewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}