package util;

public enum ConstOfPlanner {
    MONTH(12),
    MIN_OF_DATE(1),
    MAX_OF_DATE(31),
    DATE_OF_CHRISTMAS(25),
    MAX_NUM_OF_ORDER(20),
    MIN_NUM_OF_ORDER(1),
    MINIMUM_DISCOUNT_AMOUNT(10000),
    MONDAY_MODULO_BY_7(4),
    TUESDAY_MODULO_BY_7(5),
    WEDNESDAY_MODULO_BY_7(6),
    THURSDAY_MODULO_BY_7(0),
    FRIDAY_MODULO_BY_7(1),
    SATURDAY_MODULO_BY_7(2),
    SUNDAY_MODULO_BY_7(3),
    DEFAULT_AMOUNT_OF_CHRISTMAS_DDAY_DISCOUNT(1000),
    ADDITIONAL_AMOUNT_OF_CHRISTMAS_DDAY_DISCOUNT(100),
    AMOUNT_OF_WEEKDAY_DISCOUNT(2023),
    AMOUNT_OF_WEEKEND_DISCOUNT(2023),
    MINIMUM_AMOUNT_OF_GIVEAWAY_EVENT(120000),
    AMOUNT_OF_GIVEAWAY_MENU(1);

    private final int number;

    ConstOfPlanner(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
