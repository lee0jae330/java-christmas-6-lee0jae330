package domain;

import util.Appetizer;
import util.Dessert;
import util.Drink;
import util.MainDish;
import util.MenuNames;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String,Integer> getMenuDB() {
        return menuDB;
    }
}
