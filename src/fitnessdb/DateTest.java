package fitnessdb;

import org.junit.Test;
import static org.junit.Assert.*;

public class DateTest {
    //isValid() method in the Date class, 5 invalid cases, 2 valid cases.
    @Test
    public void isValidTrueTest(){
        Date d1 = new Date(2024, 2, 1);
        Date d2 = new Date(1996, 3, 30);

        assertTrue(d1.isValid(d1.getDay(),d1.getMonth(),d1.getYear()));
        assertTrue(d2.isValid(d2.getDay(),d2.getMonth(),d2.getYear()));
    }


    @Test
    public void isValidFalseTest(){
        Date d1 = new Date(2023, 2, 29); //invalid non-leap year
        Date d2 = new Date(2024, 2, 30); // invalid out of bound day
        Date d3 = new Date(2024, 0, 1); // invalid month
        Date d4 = new Date(2024, 1, 0); //invalid day
        Date d5 = new Date(Integer.MIN_VALUE, 1, 1);// invalid


        assertFalse(d1.isValid(d1.getDay(),d1.getMonth(),d1.getYear());
        assertFalse(d2.isValid(d2.getDay(),d2.getMonth(),d2.getYear());
        assertFalse(d3.isValid(d3.getDay(),d3.getMonth(),d3.getYear());
        assertFalse(d4.isValid(d4.getDay(),d4.getMonth(),d4.getYear());
        assertFalse(d5.isValid(d5.getDay(),d5.getMonth(),d5.getYear());


    }

}
