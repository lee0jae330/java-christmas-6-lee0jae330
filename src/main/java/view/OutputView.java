package view;

import util.ConstOfPlanner;
import util.OutputMessage;

public class OutputView {
    private static final int MONTH = ConstOfPlanner.MONTH.getNumber();

    public static void printStartMessage() {
        System.out.println(OutputMessage.PROGRAM_START_MSG.getMessage(MONTH));
    }
}