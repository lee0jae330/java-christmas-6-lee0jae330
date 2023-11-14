package domain;

import util.ConstOfPlanner;
import util.Drink;

public class Discount {
    private int christmasDday;
    private int weekday;
    private int weekend;
    private int special;
    private boolean isGiveawayEvent;
    private String badge;
    
    public Discount() {
        this.christmasDday = 0;
        this.weekday = 0;
        this.weekend = 0;
        this.special = 0;
        this.isGiveawayEvent = false;
        this.badge = "";
    }

    public int getChristmasDday() {
        return christmasDday;
    }

    public int getWeekday() {
        return weekday;
    }

    public int getWeekend() {
        return weekend;
    }

    public int getSpecial() {
        return special;
    }

    public int getGiveawayEvent() {
        if(isGiveawayEvent) {
            return Drink.CHAMPAGNE.getPrice();
        }
        return 0;
    }

    public String getBadge(){
        return badge;
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

    public void adjustChristmasDdayDiscount(boolean beforeChristmasDay, int date) {
        
        if(beforeChristmasDay) {
            int defaultAmount = ConstOfPlanner.DEFAULT_AMOUNT_OF_CHRISTMAS_DDAY_DISCOUNT.getNumber();
            int additionalAmount =  ConstOfPlanner.ADDITIONAL_AMOUNT_OF_CHRISTMAS_DDAY_DISCOUNT.getNumber();
            christmasDday = defaultAmount + additionalAmount * (date -1);
        }
    }    
    
    public void adjustWeekdayDiscount(boolean isWeekday, int numberOfDessert) {
        if(isWeekday) {
            weekday += ConstOfPlanner.AMOUNT_OF_WEEKDAY_DISCOUNT.getNumber() * numberOfDessert;
        }
    }

    public void adjustWeekendDiscount(boolean isWeekend, int numberOfMainDish) {
        if(isWeekend) {
            weekend += ConstOfPlanner.AMOUNT_OF_WEEKEND_DISCOUNT.getNumber() * numberOfMainDish;
        }
    }

    public void adjustSpecialDiscount(boolean isSpecialDay) {
        if(isSpecialDay) {
            special += 1000;
        }
    }

    public void adjustGiveawayEvent(int priceBeforeDiscount) {
        if(priceBeforeDiscount >= ConstOfPlanner.MINIMUM_AMOUNT_OF_GIVEAWAY_EVENT.getNumber()) {
            isGiveawayEvent = true;
        }
    }

    public void analyzeBadge() {
        int totalDiscount = calculateTotalDiscount();
        if(totalDiscount >= 20000) {
            badge = "산타";
        }
        else if(totalDiscount >= 10000) {
            badge = "트리";
        }
        else if(totalDiscount >= 5000) {
            badge = "별";
        }
    }
 }
