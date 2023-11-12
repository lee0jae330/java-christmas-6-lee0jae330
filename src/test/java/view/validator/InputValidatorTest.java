package view.validator;

import exception.InvalidDateFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @DisplayName("날짜에 빈 문자열(\"\")이 주어지면 예외 발생(InvalidDateFormat)")
    @Test
    void dateIsEmpty() {
        assertThatThrownBy(() -> inputValidator.checkDateValidation(""))
                .isInstanceOf(InvalidDateFormatException.class);
    }

    @DisplayName("주문에 빈 문자열(\"\")이 주어지면 예외 발생(InvalidDateFormat)")
    @Test
    void orderIsEmpty() {
        assertThatThrownBy(() -> inputValidator.checkOrderValidation(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

}