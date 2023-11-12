package validator;

import domain.MenuNameDb;
import exception.MenuIsNotInMenuDbException;

public class MenuNameValidator {
    
    public static void checkMenuNameValidation(String name) {
        checkIsInMenuDb(name);
    }

    private static void checkIsInMenuDb(String name) {
        MenuNameDb menuNameDb = new MenuNameDb();
        if(!menuNameDb.isInMenuDB(name)) {
            throw new MenuIsNotInMenuDbException();
        }
    }
}
