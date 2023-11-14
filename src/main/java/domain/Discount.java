package domain;

import util.Drink;

public class Discount {
    private int christmasDday;
    private int weekday;
    private int weekend;
    private int special;
    boolean isGiveawayEvent;

    public Discount() {
        this.christmasDday = 0;
        this.weekday = 0;
        this.weekend = 0;
        this.special = 0;
        this.isGiveawayEvent = false;
    }

    public int calculateRealDiscountAmount() {
        return christmasDday + weekday + weekend + special;
    }

    public int calculateTotalDiscount() {
        int sum = christmasDday + weekday + weekend + special;
        if(isGiveawayEvent) {
            sum += Drink.CHAMPAGNE.getPrice();
        }
        return sum;
    }
 }
