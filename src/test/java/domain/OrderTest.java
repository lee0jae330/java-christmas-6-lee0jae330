package domain;

import exception.InvalidOrderFormatException;
import exception.MenuIsNotInMenuDbException;
import exception.OutOfOrderNumberRangeException;
import exception.QuantityNumberFormatException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import util.Appetizer;
import util.MainDish;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @DisplayName("1차 파싱된 입력이 잘못된 형식일시 예외 발생(올바른 형식: 메뉴-수량)")
    @ParameterizedTest
    @ValueSource(strings= {"티본스테이크=2","타파스~1","초코케이크_2"})
    void invalidFormat(String input) {
        assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(InvalidOrderFormatException.class);
    }

    @DisplayName("메뉴DB에 없는 메뉴로 초기화 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"간장계란밥-2","감자전-1","계란말이-2"})
    void wrongMenuInit(String menu) {
        assertThatThrownBy(() -> new Order(menu))
                .isInstanceOf(MenuIsNotInMenuDbException.class);
    }

    @DisplayName("주문 수량에 숫자 이외 문자 입력 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"초코케이크-두개","제로콜라-2ea","시저샐러드-one"})
    void quantityContainCharacter(String input) {
        assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(QuantityNumberFormatException.class);
    }

    @DisplayName("주문 수량이 주문 가능 최소 수량보다 적으면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"타파스-0","초코케이크-0"})
    void lessThanMinimumAmount(String input) {
        assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(OutOfOrderNumberRangeException.class);
    }

    @DisplayName("주문 수량이 주문 가능 최대 수량보다 크면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"시저샐러드-21","초코케이크-100","제로콜라-10000"})
    void exceedMaximumAmount(String input) {
        assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(OutOfOrderNumberRangeException.class);
    }

    @DisplayName("초기화가 잘 되는지 확인")
    @Test
    void initTest() {
        Order order = new Order(Appetizer.CAESER_SALAD.getMenu()+"-"+15);
        assertEquals(Appetizer.CAESER_SALAD.getMenu(),order.getMenu());
        assertEquals(15,order.getQuantity());
    }

    @DisplayName("가격이 초기화 잘 되는지 확인")
    @Test
    void initPriceTest() {
        Order order = new Order();
        order.setPrice(1000);
        assertEquals(1000,order.getPrice());
    }

    @DisplayName("카테고리가 초기화 잘 되는 지 확인")
    @Test
    void initCategoryTest() {
        Order order = new Order();
        order.setCategory(Appetizer.CATEGORY.getMenu());

        assertEquals(Appetizer.CATEGORY.getMenu(),order.getCategory());
    }
    @DisplayName("주어진 카테고리와 카테고리가 일치하면 true 반환")
    @Test
    void isSameCategory() {
        Order order = new Order("티본스테이크-2");
        order.setCategory(MainDish.CATEGORY.getMenu());

        assertTrue(order.isEqualCategory(MainDish.CATEGORY.getMenu()));
    }
}