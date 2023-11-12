package domain;

import util.MenuNames;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuNameDB {
    Set<String> menuDB = new HashSet<>();
    List<String> appetizer = MenuNames.APPETIZER.getMenuName();
    List<String> mainDish = MenuNames.MAIN_DISH.getMenuName();
    List<String> dessert = MenuNames.DESSERT.getMenuName();
    List<String> drink = MenuNames.DRINK.getMenuName();

    public void initDB() {
        menuDB.addAll(appetizer);
        menuDB.addAll(mainDish);
        menuDB.addAll(dessert);
        menuDB.addAll(drink);
    }

    public boolean isInMenuDB(String name) {
        return menuDB.contains(name);
    }

    public Set<String> getMenuDB() {
        return menuDB;
    }
}
