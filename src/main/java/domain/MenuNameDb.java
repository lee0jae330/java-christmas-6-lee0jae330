package domain;

import java.util.HashMap;
import java.util.Map;

import util.Appetizer;
import util.Dessert;
import util.Drink;
import util.MainDish;

public class MenuNameDb {

    Map<String,Integer> menuDB = new HashMap<>();
    Map<String,Integer> appetizer;
    Map<String,Integer> mainDish;
    Map<String,Integer> dessert;
    Map<String,Integer> drink;
    
    public MenuNameDb() {
        setAppetizer();
        setMainDish();
        setDessert();
        setDrink();
        initDb();
    }

    private void setAppetizer() {
        appetizer = Appetizer.getAllMenu();
    }

    private void setMainDish() {
        mainDish = MainDish.getAllMenu();
    }

    private void setDessert() {
        dessert = Dessert.getAllMenu();
    }

    private void setDrink() {
        drink = Drink.getAllMenu();
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
