package util;

import java.util.HashMap;
import java.util.Map;

public enum MainDish implements Menu {
    
    CATEGORY("메인",0),
    T_BONE_STEAK("티본스테이크",55000),
    BARBECUE_RIBS("바비큐립",54000),
    SEAFOOD_PASTA("해산물파스타",35000),
    CHRISTMAS_PASTA("크리스마스파스타",25000);

    private final String menu;
    private final int price;

    MainDish(String menu, int price) {
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
        Map<String,Integer> mainDish = new HashMap<>();
        for(MainDish md : values()) {
            mainDish.put(md.getMenu(),md.getPrice());
        }
        return mainDish;
    }
    
}
