package validator;

import exception.InvalidDateFormatException;
import exception.OutOfDateRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DateValidatorTest {

    @DisplayName("날짜에 숫자 이외의 문자가 입력되면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings ={"12a","first","l2","1o"})
    void dateContainCharacter(String input) {
        assertThatThrownBy(() -> DateValidator.checkDateValidation(input))
                .isInstanceOf(InvalidDateFormatException.class);

    }

    @DisplayName("날짜의 범위를 넘는 숫자 입력 시 예외 발생 (범위: 1~31")
    @ParameterizedTest
    @ValueSource(strings = {"34","50","-10","0"})
    void outOfDateRange(String input) {
        assertThatThrownBy(() -> DateValidator.checkDateValidation(input))
                .isInstanceOf(OutOfDateRangeException.class);
    }

}