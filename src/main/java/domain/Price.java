package domain;

public class Price {
    private final int totalPriceBeforeDiscount;
    private int totalPriceAfterDiscount;

    public Price(int price) {
        this.totalPriceBeforeDiscount = price;
    }

    public int getTotalPriceBeforeDiscount() {
        return totalPriceBeforeDiscount;
    }
}
