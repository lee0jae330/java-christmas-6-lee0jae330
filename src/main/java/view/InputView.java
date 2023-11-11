package view;

import camp.nextstep.edu.missionutils.Console;

import util.InputMessage;
import view.validator.InputValidator;

public class InputView {
    private static final InputValidator inputValidator = new InputValidator();

    public static String enterDate() {
        System.out.println(InputMessage.ENTER_DATE.getMessage());
        String input = Console.readLine();
        return inputValidator.checkInputValidation(input);
    }

    public static String enterMenu() {
        System.out.println(InputMessage.ENTER_MENU.getMessage());
        String input = Console.readLine();
        return  inputValidator.checkInputValidation(input);
    }
}