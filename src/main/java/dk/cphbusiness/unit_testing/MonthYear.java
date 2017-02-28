package dk.cphbusiness.unit_testing;

import java.time.LocalDate;

/**
 *
 * @author nikolai
 */
public class MonthYear {

    public int getNumDaysInMonth(int month, int year){
        if(month < 1 || month > 12 || year <= 0 || year > Integer.MAX_VALUE)
            return -1;
        
        LocalDate date = LocalDate.of(year, month, 1);
        int lengthOfMonth = date.lengthOfMonth();
        //boolean isLeapYear = date.isLeapYear();
        
        return lengthOfMonth;        
    }
    
}
