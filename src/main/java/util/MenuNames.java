package util;

import java.util.Arrays;
import java.util.List;

public enum MenuNames {
    APPETIZER("양송이수프,타파스,시저샐러드"),
    MAIN_DISH("티본스테이크,바비큐립,해산물파스타,크리스마스파스타"),
    DESSERT("초코케이크,아이스크림"),
    DRINK("제로콜라,레드와인,샴페인");

    private final String menuName;

    MenuNames(String menuName) {
        this.menuName = menuName;
    }

    public List<String> getMenuName() {
        return Arrays.asList(menuName.split(","));
    }
}
