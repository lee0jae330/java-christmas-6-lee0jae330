package domain;

import util.Appetizer;
import util.MenuNames;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuNameDb {
    Map<String,Integer> menuDB = new HashMap<>();
    Set<String> menuDB = new HashSet<>();

    Map<String,Integer> appetizer;

    
    List<String> mainDish = MenuNames.MAIN_DISH.getMenuName();
    List<String> dessert = MenuNames.DESSERT.getMenuName();
    List<String> drink = MenuNames.DRINK.getMenuName();

    public MenuNameDb() {
        initDb();
    }

    private void initAppetizer() {
        appetizer = Appetizer.getAllAppetizer();
    }

    private void initMainDish() {
        
    }

    private void initDb() {
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
