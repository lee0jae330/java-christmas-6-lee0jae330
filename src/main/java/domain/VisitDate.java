package domain;

import util.ConstOfPlanner;
import validator.DateValidator;

public class VisitDate {
    private int date;

    public VisitDate(String input) {
        this.date = DateValidator.checkDateValidation(input);
    }

    public int getDate() {
        return date;
    }

    public boolean isWeekday() {
        int moduloResultBy7 = date % 7;
        if( moduloResultBy7 == ConstOfPlanner.SUNDAY_MODULO_BY_7.getNumber() ||
            moduloResultBy7 == ConstOfPlanner.MONDAY_MODULO_BY_7.getNumber() || 
            moduloResultBy7 == ConstOfPlanner.TUESDAY_MODULO_BY_7.getNumber() || 
            moduloResultBy7 == ConstOfPlanner.WEDNESDAY_MODULO_BY_7.getNumber() ||
            moduloResultBy7 == ConstOfPlanner.THURSDAY_MODULO_BY_7.getNumber()) {
                return true;
            }
        return false;
    }

    public boolean beforeChristmasDay() {
        return date <= ConstOfPlanner.DATE_OF_CHRISTMAS.getNumber();
    }

    public boolean isWeekend() {
        int moduloResultBy7 = date % 7;
        if(moduloResultBy7 == ConstOfPlanner.FRIDAY_MODULO_BY_7.getNumber() || moduloResultBy7 == ConstOfPlanner.SATURDAY_MODULO_BY_7.getNumber()) {
            return true;
        }
        return false;
    }

    public boolean isSpecialDay() {
        int moduloResultBy7 =  date % 7;
        if(moduloResultBy7 == ConstOfPlanner.SUNDAY_MODULO_BY_7.getNumber() || date == ConstOfPlanner.DATE_OF_CHRISTMAS.getNumber()) {
            return true;
        }
        return false;
    }
}
