package domain;

import exception.InvalidDateFormatException;
import exception.OutOfDateRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
class VisitDateTest {

    @DisplayName("날짜에 숫자 이외의 문자 포함되어 있으면 예외 발생(InvalidDateFormat)")
    @ParameterizedTest
    @ValueSource(strings =  {"12a","1o","twentyfive"})
    void dateContainsCharacter(String input) {
        assertThatThrownBy(() -> new VisitDate(input))
                .isInstanceOf(InvalidDateFormatException.class);
    }

    @DisplayName("날짜에 1이상 31이하의 범위 이외의 숫자가 주어지면 예외 발생(OutOfDateRange)")
    @ParameterizedTest
    @ValueSource(strings = {"-12","32","0"})
    void outOfDateRange(String input) {
        assertThatThrownBy(() -> new VisitDate(input))
                .isInstanceOf(OutOfDateRangeException.class);
    }
}