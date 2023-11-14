package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.MainDish;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @DisplayName("주어진 카테고리와 카테고리가 일치하면 true 반환")
    @Test
    void isSameCategory() {
        Order order = new Order("티본스테이크-2");
        order.setCategory(MainDish.CATEGORY.getMenu());

        assertTrue(order.isEqualCategory(MainDish.CATEGORY.getMenu()));
    }
}