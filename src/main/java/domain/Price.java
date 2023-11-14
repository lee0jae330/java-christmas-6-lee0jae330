package domain;

import util.ConstOfPlanner;

public class Price {
    private final int totalPriceBeforeDiscount;
    private int totalPriceAfterDiscount;

    public Price(int price) {
        this.totalPriceBeforeDiscount = price;
        this.totalPriceAfterDiscount = price;
    }

    public void calculateTotalPriceAfterDiscount(int amountOfdiscount) {
        this.totalPriceAfterDiscount -= amountOfdiscount;
    }

    public boolean checkDiscoutEligibility() {
        return totalPriceBeforeDiscount >= ConstOfPlanner.MINIMUM_DISCOUNT_AMOUNT.getNumber();
    }

    public int getTotalPriceBeforeDiscount() {
        return totalPriceBeforeDiscount;
    }
}
