package domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import util.MenuNames;

import java.util.ArrayList;
import java.util.List;

class MenuNameDBTest {
    private final MenuNameDb menuNameDB = new MenuNameDb();

    @DisplayName("메뉴 목록이 초기화 됐는지 확인")
    @Test
    void checkInitCorrectly() {
        List<String> menus = new ArrayList<>();
        menus.addAll(MenuNames.APPETIZER.getMenuName());
        menus.addAll(MenuNames.MAIN_DISH.getMenuName());
        menus.addAll(MenuNames.DESSERT.getMenuName());
        menus.addAll(MenuNames.DRINK.getMenuName());

        for(String name : menus) {
            Assertions.assertTrue(menuNameDB.isInMenuDB(name));
        }
        Assertions.assertEquals(menus.size(),menuNameDB.getMenuDB().size());
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
}