package util;

import java.util.HashMap;
import java.util.Map;

public enum Appetizer implements Menu {

    CATEGORY("에피타이저",0),
    YANGSONGSUPE("양송이수프",6000),
    TAPAS("타파스",5500),
    CAESER_SALAD("시저샐러드",8000);
    
    private final String menu;
    private final int price;

    Appetizer(String menu, int price) {
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
        Map<String,Integer> appetizer = new HashMap<>();
        for(Appetizer ap : values()) {
            appetizer.put(ap.getMenu(),ap.getPrice());
        }
        return appetizer;
    }
}
