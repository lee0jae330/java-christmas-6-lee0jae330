package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.prefs.PreferenceChangeEvent;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {

    @DisplayName("초기화가 잘 되는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1000,10000,100000})
    void initTest(int money) {
        Price price = new Price(money);
        assertEquals(money, price.getTotalPriceBeforeDiscount());
        assertEquals(money, price.getTotalPriceAfterDiscount());
    }

    @DisplayName("혜택이 적용되는 금액인지 확인하는 기능 테스트")
    @Test
    void canAdjustBenefit() {
        Price price1 = new Price(5000);
        Price price2 = new Price(10000);

        //혜택은 10,000원 이상부터 적용됨

        assertFalse(price1.checkDiscoutEligibility());
        assertTrue(price2.checkDiscoutEligibility());
    }

    @DisplayName("혜택 적용될 때 가격이 할인되는지 확인")
    @Test
    void checkDiscount() {
        int beforeDiscount = 100000;
        int amountOfDiscout = 10000;

        Price price = new Price(beforeDiscount);
        price.calculateTotalPriceAfterDiscount(amountOfDiscout);

        assertEquals(beforeDiscount-amountOfDiscout,price.getTotalPriceAfterDiscount());
    }
}