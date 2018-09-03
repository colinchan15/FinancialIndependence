package main.java;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

// standard age calculator mainly used for getting TFSA contribution limits
public class AgeCalculator {

    public static void main(String[] args) {
        AgeCalculator ageCalculator = new AgeCalculator();
        System.out.println(ageCalculator.getAge("1996-05-06"));
    }

    public static int ageCalculator (String birthDate, String currentDate){
        LocalDate birthDateParsed = LocalDate.parse(birthDate);
        LocalDate currentDateParsed = LocalDate.parse(currentDate);
        if ((birthDateParsed != null) && (currentDateParsed != null)) {
            return Period.between(birthDateParsed, currentDateParsed).getYears();
        } else {
            return 0;
        }
    }

    public static String getCurrentDate (){
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        return date.toString();
    }

    public static int getAge(String birthDate){
        String currentDate = getCurrentDate();
        return ageCalculator(birthDate, currentDate);
    }

    public int yearEighteen (int clientAge){
        int yearsAfterEighteen = clientAge-18;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int yearEighteen = currentYear-yearsAfterEighteen;
        return yearEighteen;
    }
}
