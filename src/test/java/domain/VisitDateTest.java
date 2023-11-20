package domain;

import exception.InvalidDateFormatException;
import exception.OutOfDateRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

    @DisplayName("평일 날짜가 주어지면 true 반환") //날짜를 7로 나누었을 때 나머지가 0,3,4,5,6 이면 평일
    @ParameterizedTest
    @ValueSource(strings = {"5","14","20","17","25"})
    void isWeekday(String input) {
        VisitDate visitDate = new VisitDate(input);
        assertTrue(visitDate.isWeekday());
    }

    @DisplayName("평일이 아닌 날짜가 입력되면 false 반환") //날짜를 7로 나누었을 때 나머지가 1,2 이면 주말
    @ParameterizedTest
    @ValueSource(strings = {"1","9","15","23"})
    void isNotWeekday(String input) {
        VisitDate visitDate = new VisitDate(input);
        assertFalse(visitDate.isWeekday());
    }

    @DisplayName("주말 날짜가 주어지면 true 반환") //날짜를 7로 나누었을 때 나머지가 1,2 이면 주말
    @ParameterizedTest
    @ValueSource(strings = {"1","2","9","15","23"})
    void isWeekend(String input) {
        VisitDate visitDate = new VisitDate(input);
        assertTrue(visitDate.isWeekend());
    }

    @DisplayName("주말이 아닌 날짜가 주어지면 false 반환") //날짜를 7로 나누었을 때 나머지가 0,3,4,5,6 이면 평일
    @ParameterizedTest
    @ValueSource(strings = {"7","24","25","18","20"})
    void isNotWeekend(String input) {
        VisitDate visitDate = new VisitDate(input);
        assertFalse(visitDate.isWeekend());
    }

    @DisplayName("별이 있는 날짜가 주어지면 true 반환") //날짜를 7로 나누었을 때 3 이거나 날짜가 25이면 별이 있음
    @ParameterizedTest
    @ValueSource(strings = {"3","10","17","24","25","31"})
    void isSpecialDay(String input) {
        VisitDate visitDate = new VisitDate(input);
        assertTrue(visitDate.isSpecialDay());
    }

    @DisplayName("별이 없는 날짜가 주어지면 false 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1","9","27","18","30"})
    void isNotSpecialDay(String input) {
        VisitDate visitDate = new VisitDate(input);
        assertFalse(visitDate.isSpecialDay());
    }

    @DisplayName("크리스마스 이전 날짜가 주어지면 true 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1","13","5","20","18","25"})
    void dateBeforeChristmas(String input) {
        VisitDate visitDate = new VisitDate(input);
        assertTrue(visitDate.beforeChristmasDay());
    }

    @DisplayName("크리스마스 이후 날짜가 주어지면 false 반환")
    @ParameterizedTest
    @ValueSource(strings = {"26","27","28","29","30","31"})
    void dateAfterChristmas(String input) {
        VisitDate visitDate = new VisitDate(input);
        assertFalse(visitDate.beforeChristmasDay());
    }
}