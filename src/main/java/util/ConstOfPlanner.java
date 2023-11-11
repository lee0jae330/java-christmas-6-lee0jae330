package util;

public enum ConstOfPlanner {
    MONTH(12),
    MIN_OF_DATE(1),
    MAX_OF_DATE(31),
    DATE_OF_CHRISTMAS(25);

    private final int number;

    ConstOfPlanner(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
