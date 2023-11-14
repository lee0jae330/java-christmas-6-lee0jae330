package domain;

import com.sun.tools.javac.Main;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.Appetizer;
import util.Dessert;
import util.Drink;
import util.MainDish;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class MenuNameDbTest {
    private final MenuNameDb menuNameDB = new MenuNameDb();

    @DisplayName("메뉴 목록이 초기화 됐는지 확인")
    @Test
    void checkInitCorrectly() {
        Map<String,Integer> allMenu = new HashMap<>();

        allMenu.putAll(Appetizer.getAllMenu());
        allMenu.putAll(MainDish.getAllMenu());
        allMenu.putAll(Dessert.getAllMenu());
        allMenu.putAll(Drink.getAllMenu());

        Set<String> allMenuName = allMenu.keySet();

        for(String name : allMenuName) {
            Assertions.assertTrue(menuNameDB.isInMenuDB(name));
        }
        Assertions.assertEquals(allMenuName.size(),menuNameDB.getMenuDB().size());
    }

    @DisplayName("주어진 메뉴 이름이 메뉴DB에 있으면 true 반환")
    @ParameterizedTest
    @ValueSource(strings = {"타파스","레드와인","아이스크림"})
    void checkIsInMenuDB(String menuName) {
        Assertions.assertTrue(menuNameDB.isInMenuDB(menuName));
    }

    @DisplayName("주어진 메뉴 이름이 메뉴DB에 없으면 false 반환")
    @ParameterizedTest
    @ValueSource(strings = {"볶음밥","된장국","계란후라이"})
    void checkIsNotInMenuDB(String menuName) {
        Assertions.assertFalse(menuNameDB.isInMenuDB(menuName));
    }

    @DisplayName("메뉴DB에 있는 메뉴가 주어지면 해당 메뉴의 카테고리를 반환")
    @Test
    void findCategoryByMenuName() {
        Assertions.assertEquals(Appetizer.CATEGORY.getMenu(), menuNameDB.findCategory("시저샐러드"));
        Assertions.assertEquals(MainDish.CATEGORY.getMenu(), menuNameDB.findCategory("티본스테이크"));
        Assertions.assertEquals(Drink.CATEGORY.getMenu(), menuNameDB.findCategory("제로콜라"));
        Assertions.assertEquals(Dessert.CATEGORY.getMenu(), menuNameDB.findCategory("초코케이크"));
    }

    @DisplayName("메뉴DB에 있는 메뉴가 주어지면 해당 메뉴의 가격을 반환")
    @Test
    void getPriceByMenuNames() {
        Assertions.assertEquals(Appetizer.TAPAS.getPrice(), menuNameDB.getPrice("타파스"));
        Assertions.assertEquals(MainDish.CHRISTMAS_PASTA.getPrice(), menuNameDB.getPrice("크리스마스파스타"));
        Assertions.assertEquals(Dessert.CHOCO_CAKE.getPrice(), menuNameDB.getPrice("초코케이크"));
        Assertions.assertEquals(Drink.CHAMPAGNE.getPrice(), menuNameDB.getPrice("샴페인"));
    }

}