package validator;

import exception.OutOfOrderNumberRangeException;
import exception.QuantityNumberFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
class QuantityValidatorTest {

    @DisplayName("수량에 숫자가 아닌 문자가 주어지면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"12a","l2","1o","1oo"})
    void quantityContainCharacter(String input) {
        assertThatThrownBy(() -> QuantityValidator.checkQuantityValidation(input))
                .isInstanceOf(QuantityNumberFormatException.class);
    }

    @DisplayName("수량 범위에 벗어난 숫자가 주어지면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1","0","21","100"})
    void outOfQuantityRange(String input) {
        assertThatThrownBy(() -> QuantityValidator.checkQuantityValidation(input))
                .isInstanceOf(OutOfOrderNumberRangeException.class);
    }

}