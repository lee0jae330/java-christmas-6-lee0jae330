package util;

public enum OutputMessage {
    PROGRAM_START_MSG("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다."),
    BENEFIT_PREVIEW("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDERED_MENU("<주문 메뉴>"),
    TOTAL_PRICE_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    BENEFIT_LIST("<혜택 내역>"),
    TOTAL_BENEFIT_PRICE("<총혜택 금액>"),
    TOTAL_PRICE_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    EVENT_BADGE("<%d월 이벤트 배지>");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int month) {
        return String.format(message,month);
    }

    public String getMessage(int month, int date) {
        return String.format(message,month,date);
    }
}
