package validator;

import exception.InvalidOrderFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderInputFormatValidatorTest {
    /**1차 파싱할 때 사용하는 유효성 검사*/

    @DisplayName("잘못된 형식의 입력이 주문으로 주어지면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings =  {",티본스테이크-2,초코케이크-1","티본스테이크-2,,초코케이크-1","티본스테이크-2,초코케이크-1,"})
    void invalidInputFormat(String input) {
        assertThatThrownBy(() -> OrderInputFormatValidator.checkOrderInputFormatValidator(input))
                .isInstanceOf(InvalidOrderFormatException.class);
    }
}