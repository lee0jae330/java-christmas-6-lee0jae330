package util;

import java.util.HashMap;
import java.util.Map;

public enum Drink implements Menu {
    
    ZERO_COLA("제로콜라",3000),
    RED_WINE("레드와인",60000),
    CHAMPAGNE("샴페인",25000);
    
    private final String menu;
    private final int price;

    Drink(String menu, int price) {
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
        Map<String,Integer> drink = new HashMap<>();
        for(Drink d : values()) {
            drink.put(d.getMenu(),d.getPrice());
        }
        return drink;
    }
}
