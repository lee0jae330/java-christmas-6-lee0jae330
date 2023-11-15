package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.ConstOfPlanner;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    @DisplayName("초기화가 잘 됐는지 확인")
    @Test
    void initTest() {
        Discount discount = new Discount();

        assertEquals(0,discount.getChristmasDday());
        assertEquals(0,discount.getWeekday());
        assertEquals(0,discount.getWeekend());
        assertEquals(0,discount.getSpecial());
        assertEquals(0,discount.getGiveawayEvent());
        assertEquals("",discount.getBadge());
    }

    @DisplayName("크리스마스 D-DAY 할인 적용 확인")
    @Test
    void christmasDday() {
        Discount discount = new Discount();
        discount.adjustChristmasDdayDiscount(true, 15);
        assertEquals(1000+100*14,discount.getChristmasDday());

        discount = new Discount();
        discount.adjustChristmasDdayDiscount(false,26);
        assertEquals(0,discount.getChristmasDday());

    }

    @DisplayName("평일 할인 적용 확인")
    @Test
    void weekday() {
        Discount discount = new Discount();
        discount.adjustWeekdayDiscount(true, 3);
        assertEquals(2023*3 , discount.getWeekday());

        discount = new Discount();
        discount.adjustWeekdayDiscount(false,4);
        assertEquals(0,discount.getWeekday());
    }

    @DisplayName("주말 할인 적용 확인")
    @Test
    void weekend() {
        Discount discount = new Discount();
        discount.adjustWeekendDiscount(true, 5);
        assertEquals(2023*5, discount.getWeekend());

        discount = new Discount();
        discount.adjustWeekendDiscount(false,10);
        assertEquals(0, discount.getWeekend());
    }

    @DisplayName("특별 할인 적용 확인")
    @Test
    void special() {
        Discount discount = new Discount();
        discount.adjustSpecialDiscount(true);
        assertEquals(1000,discount.getSpecial());

        discount = new Discount();
        discount.adjustSpecialDiscount(false);
        assertEquals(0,discount.getSpecial());
    }

    @DisplayName("증정 이벤트 적용 확인")
    @Test
    void giveawayEvent() {
        Discount discount = new Discount();
        discount.adjustGiveawayEvent(10000); //증정 이벤트 최소 주문 금액은 12만원이다.
        assertEquals(0, discount.getGiveawayEvent());

        discount.adjustGiveawayEvent(120000);
        assertEquals(25000,discount.getGiveawayEvent());
    }

    @DisplayName("혜택 금액이 따른 뱃지 변경 여부 확인")
    @Test
    void checkBadge() {
        Discount discount = new Discount();
        discount.adjustSpecialDiscount(true);
        discount.analyzeBadge();
        //혜택 금액 5000원 미만 뱃지 : 없음
        assertEquals("",discount.getBadge());

        discount.adjustWeekdayDiscount(true,2);
        discount.analyzeBadge();
        //5000원 이상: 별
        assertEquals("별",discount.getBadge());

        discount.adjustWeekdayDiscount(true, 3);
        discount.analyzeBadge();
        //10000원 이상: 트리
        assertEquals("트리",discount.getBadge());

        discount.adjustGiveawayEvent(120000);
        discount.analyzeBadge();
        //20000원 이상: 산타
        assertEquals("산타", discount.getBadge());
    }

    @DisplayName("실혜택 금액 계산 확인")
    @Test
    void checkCalculateRealDiscount() {
        Discount discount = new Discount();
        discount.adjustChristmasDdayDiscount(true, 3);
        discount.adjustWeekdayDiscount(true, 2);
        discount.adjustSpecialDiscount(true);

        assertEquals(1000+100*2+2023*2+1000, discount.calculateRealDiscountAmount());
    }

    @DisplayName("총 혜택 금액 계산 확인")
    @Test
    void checkTotalDiscount() {
        Discount discount = new Discount();
        discount.adjustChristmasDdayDiscount(true, 25);
        discount.adjustGiveawayEvent(120000);
        discount.adjustWeekdayDiscount(true, 10);

        assertEquals(1000+100*24+25000+2023*10, discount.calculateTotalDiscount());
    }
}