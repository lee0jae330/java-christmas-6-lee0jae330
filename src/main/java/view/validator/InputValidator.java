package view.validator;

public class InputValidator {
    public String checkInputValidation(String input) {
        checkInputIsEmpty(input);
        return input;
    }

    private void  checkInputIsEmpty(String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
