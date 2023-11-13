package util;

import java.util.HashMap;
import java.util.Map;

public enum Dessert implements Menu {

    CATEGORY("디저트",0),
    CHOCO_CAKE("초코케이크",15000),
    ICECREAM("아이스크림",5000);

    private final String menu;
    private final int price;

    Dessert(String menu, int price) {
        this.menu = menu;
        this.price = price;
    }

    public String getMenu() {
        return menu;
    }

    public int getPrice() {
        return price;
    }

    public static Map<String,Integer> getAllMenu() {
        Map<String,Integer> dessert = new HashMap<>();
        for(Dessert d : values()) {
            dessert.put(d.getMenu(),d.getPrice());
        }
        return dessert;
    }
}
