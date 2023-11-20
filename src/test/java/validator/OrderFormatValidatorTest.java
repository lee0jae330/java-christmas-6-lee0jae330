package validator;

import exception.InvalidOrderFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class OrderFormatValidatorTest {

    @DisplayName("잘못된 형식의 주문 형태 입력 시 예외 발생 (올바른 형식:메뉴-수량)")
    @ParameterizedTest
    @ValueSource(strings = {"a--c","-aa-","aa-","-a","a-a-a","a-a--"})
    void checkInvalidOrderFormat(String input) {
        assertThatThrownBy(() -> OrderFormatValidator.checkOrderFormat(input))
                .isInstanceOf(InvalidOrderFormatException.class);
    }
}