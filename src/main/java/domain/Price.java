package domain;

import util.ConstOfPlanner;

public class Price {
    private final int totalPriceBeforeDiscount;
    private final int totalPriceAfterDiscount;

    public Price(int price) {
        this.totalPriceBeforeDiscount = price;
        this.totalPriceAfterDiscount = price;
    }

    public boolean checkDiscoutEligibility() {
        return totalPriceBeforeDiscount >= ConstOfPlanner.MINIMUM_DISCOUNT_AMOUNT.getNumber();
    }

    public int getTotalPriceBeforeDiscount() {
        return totalPriceBeforeDiscount;
    }
}
