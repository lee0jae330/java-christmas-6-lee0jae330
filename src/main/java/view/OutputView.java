package view;

import java.text.NumberFormat;
import java.util.Map;
import java.util.Set;

import util.ConstOfPlanner;
import util.OutputMessage;

public class OutputView {

    private static final NumberFormat formatter = NumberFormat.getNumberInstance();
    private static final int MONTH = ConstOfPlanner.MONTH.getNumber();

    public static void printStartMessage() {
        System.out.println(OutputMessage.PROGRAM_START_MSG.getMessage(MONTH));
    }

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printBenefitPreview(int date) {
        System.out.println(OutputMessage.BENEFIT_PREVIEW.getMessage(MONTH,date));
        printEmptyLine();
    }

    public static void printOrders(Map<String,Integer>orderInformation) {
        Set<String> menuNames = orderInformation.keySet();

        System.out.println(OutputMessage.ORDERED_MENU.getMessage());
        for(String name : menuNames) {
            System.out.printf("%s %d개\n",name,orderInformation.get(name));
        }
        printEmptyLine();
    }

    public static void printPriceBeforeDiscount(int price) {
        System.out.println(OutputMessage.TOTAL_PRICE_BEFORE_DISCOUNT.getMessage());
        System.out.println(formatter.format(price)+"원");
        printEmptyLine();
    }

    public static void printGiveawayMenu(int giveawayEvent, String freeMenu, int amount) {
        System.out.println(OutputMessage.GIVEAWAY_MENU.getMessage());
        if(giveawayEvent > 0) {
            System.out.println(freeMenu+" "+amount+"개");
            printEmptyLine();
            return;
        }
        System.out.println(OutputMessage.NOTHING.getMessage());
        printEmptyLine();
    }

    public static void printAllBenefit(int christmas, int weekday, int weekend,int special, int giveawayEvent) {
        System.out.println(OutputMessage.BENEFIT_LIST.getMessage());
        if(christmas == 0 && weekday == 0 && weekend == 0 && giveawayEvent == 0) {
            System.out.println(OutputMessage.NOTHING.getMessage());
            printEmptyLine();
            return;
        }
        printChristmas(christmas);
        printWeekday(weekday);
        printWeekend(weekend);
        printSpecial(special);
        printGiveawayEvent(giveawayEvent);
        printEmptyLine();
    }

    private static void printChristmas(int christmas) {
        if(christmas > 0) {
            System.out.println(OutputMessage.CHRISTMAS_DDAY_DISCOUNT.getMessage(formatter.format(-christmas)));
        }
    }

    private static void printWeekday(int weekday) {
        if(weekday > 0) {
            System.out.println(OutputMessage.WEEKDAY_DISCOUNT.getMessage(formatter.format(-weekday)));
        }
    }

    private static void printWeekend(int weekend) {
        if(weekend > 0) {
            System.out.println(OutputMessage.WEEKEND_DISCOUNT.getMessage(formatter.format(-weekend)));
        }
    }

    private static void printSpecial(int special) {
        if(special > 0) {
            System.out.println(OutputMessage.SPECIAL_DISCOUNT.getMessage(formatter.format(-special)));
        }
    }

    private static void printGiveawayEvent(int giveawayEvent) {
        if(giveawayEvent > 0) {
            System.out.println(OutputMessage.GIVEAWAY_EVENT.getMessage(formatter.format(-giveawayEvent)));
        }
    }

    public static void printTotalBenefit(int price) {
        System.out.println(OutputMessage.TOTAL_BENEFIT_PRICE.getMessage());
        System.out.println(formatter.format(-price)+"원");
        printEmptyLine();
    }
    
    public static void printPriceAfterDiscount(int price) {
        System.out.println(OutputMessage.TOTAL_PRICE_AFTER_DISCOUNT.getMessage());
        System.out.println(formatter.format(price)+"원");
        printEmptyLine();
    }

    public static void printBadge(String badge) {
        System.out.println(OutputMessage.EVENT_BADGE.getMessage(MONTH));
        if(badge.isEmpty()) {
            System.out.println(OutputMessage.NOTHING.getMessage());
            return;
        }
        System.out.println(badge);
        printEmptyLine();
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}