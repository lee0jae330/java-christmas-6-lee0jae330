package view;

import camp.nextstep.edu.missionutils.Console;

import util.ConstOfPlanner;
import util.InputMessage;

import view.validator.InputValidator;

public class InputView {
    private static final int MONTH = ConstOfPlanner.MONTH.getNumber();
    private static final InputValidator inputValidator = new InputValidator();

    public static String enterDate() {
        System.out.println(InputMessage.ENTER_DATE.getMessage(MONTH));
        String input = Console.readLine();
        return inputValidator.checkInputValidation(input);
    }

    public static String enterMenu() {
        System.out.println(InputMessage.ENTER_MENU.getMessage(MONTH));
        String input = Console.readLine();
        return  inputValidator.checkInputValidation(input);
    }
}