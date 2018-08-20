package main.java;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {

    public int ageCalculator (String birthDate, String currentDate){
        LocalDate birthDateParsed = LocalDate.parse(birthDate);
        LocalDate currentDateParsed = LocalDate.parse(currentDate);
        if ((birthDateParsed != null) && (currentDateParsed != null)) {
            return Period.between(birthDateParsed, currentDateParsed).getYears();
        } else {
            return 0;
        }
    }

    public String getCurrentDate (){
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        return date.toString();
    }

    public int getAge(String birthDate){
        String currentDate = getCurrentDate();
        return ageCalculator(birthDate, currentDate);
    }
}
