package util;

public enum InputMessage {
    ENTER_DATE(12,"%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ENTER_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

    private final String message;
    private final int month;
    InputMessage(int month,String message) {
        this.month = month;
        this.message = message;
    }

    InputMessage(String message) {
        this.month = -1;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
