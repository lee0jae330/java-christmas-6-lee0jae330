package domain;

import java.util.HashMap;
import java.util.Map;

import util.Appetizer;
import util.Dessert;
import util.Drink;
import util.MainDish;

public class MenuNameDb {

    private final Map<String,Integer> menuDB = new HashMap<>();
    private final Map<String,Integer> appetizer = new HashMap<>(); ;
    private final Map<String,Integer> mainDish = new HashMap<>();;
    private final Map<String,Integer> dessert = new HashMap<>();;
    private final Map<String,Integer> drink = new HashMap<>();;
    
    public MenuNameDb() {
        setAppetizer();
        setMainDish();
        setDessert();
        setDrink();
        initDb();
    }

    private void setAppetizer() {
        appetizer.putAll(Appetizer.getAllMenu());
    }

    private void setMainDish() {
        mainDish.putAll(MainDish.getAllMenu());
    }

    private void setDessert() {
        dessert.putAll(Dessert.getAllMenu());
    }

    private void setDrink() {
        drink.putAll(Drink.getAllMenu());
    }

    private void initDb() {
        menuDB.putAll(appetizer);
        menuDB.putAll(mainDish);
        menuDB.putAll(dessert);
        menuDB.putAll(drink);
    }

    public boolean isInMenuDB(String name) {
        return menuDB.containsKey(name);
    }

    public String findCategory(String name) {
        if(appetizer.containsKey(name)) {
            return Appetizer.CATEGORY.getMenu();
        }
        if(mainDish.containsKey(name)) {
            return MainDish.CATEGORY.getMenu();
        }
        if(dessert.containsKey(name)) {
            return Dessert.CATEGORY.getMenu();
        }
        if(drink.containsKey(name)) {
            return Drink.CATEGORY.getMenu();
        }
        return null;
    }

    public int getPrice(String name) {
        return menuDB.get(name);
    }

    public Map<String,Integer> getMenuDB() {
        return menuDB;
    }
}
