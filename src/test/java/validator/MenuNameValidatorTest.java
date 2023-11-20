package validator;

import exception.MenuIsNotInMenuDbException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuNameValidatorTest {

    @DisplayName("메뉴DB에 없는 메뉴가 주어지면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"계란","수박화채","콩밥","누룽지"})
    void notInMenuDB(String input) {
        assertThatThrownBy(() -> MenuNameValidator.checkMenuNameValidation(input))
                .isInstanceOf(MenuIsNotInMenuDbException.class);
    }
}