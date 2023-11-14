package view;

import java.util.Map;
import java.util.Set;

import util.ConstOfPlanner;
import util.OutputMessage;

public class OutputView {
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
        System.out.println(price+"원");
        printEmptyLine();
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}