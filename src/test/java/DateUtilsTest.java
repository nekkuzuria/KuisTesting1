import org.example.DateUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateUtilsTest {
    private DateUtils myDate;
    private IllegalArgumentException exception;

    @BeforeEach
    void setUp(){
        myDate = new DateUtils();
    }


    @Test
    void testIsLeapYear(){
        // Only Mod 4
        assertEquals(true, myDate.isLeapYear(2024));

        // Only Mod 4 and Mod 100
        assertEquals(false, myDate.isLeapYear(2100));

        // Mod 4, Mod 100, and Mod 400
        assertEquals(true, myDate.isLeapYear(2000));

        // Not Mod 4
        assertEquals(false, myDate.isLeapYear(2023));
    }

    @Test
    void testGetDaysInMonth(){
        //Not Leap Year
        assertEquals(31, myDate.getDaysInMonth(2023, 1));
        assertEquals(28, myDate.getDaysInMonth(2023, 2));
        assertEquals(31, myDate.getDaysInMonth(2023, 3));
        assertEquals(30, myDate.getDaysInMonth(2023, 4));
        assertEquals(31, myDate.getDaysInMonth(2023, 5));
        assertEquals(30, myDate.getDaysInMonth(2023, 6));
        assertEquals(31, myDate.getDaysInMonth(2023, 7));
        assertEquals(31, myDate.getDaysInMonth(2023, 8));
        assertEquals(30, myDate.getDaysInMonth(2023, 9));
        assertEquals(31, myDate.getDaysInMonth(2023, 10));
        assertEquals(30, myDate.getDaysInMonth(2023, 11));
        assertEquals(31, myDate.getDaysInMonth(2023, 12));

        //Leap Year
        assertEquals(31, myDate.getDaysInMonth(2023, 1));
        assertEquals(28, myDate.getDaysInMonth(2023, 2));
        assertEquals(31, myDate.getDaysInMonth(2023, 3));
        assertEquals(30, myDate.getDaysInMonth(2023, 4));
        assertEquals(31, myDate.getDaysInMonth(2023, 5));
        assertEquals(30, myDate.getDaysInMonth(2023, 6));
        assertEquals(31, myDate.getDaysInMonth(2023, 7));
        assertEquals(31, myDate.getDaysInMonth(2023, 8));
        assertEquals(30, myDate.getDaysInMonth(2023, 9));
        assertEquals(31, myDate.getDaysInMonth(2023, 10));
        assertEquals(30, myDate.getDaysInMonth(2023, 11));
        assertEquals(31, myDate.getDaysInMonth(2023, 12));
    }

    @Test
    void testNegativeGetDaysInMonth(){
        exception = assertThrows(IllegalArgumentException.class,
                () -> myDate.getDaysInMonth(2020, 0));
        assertEquals("Invalid month value: 0", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,
                () -> myDate.getDaysInMonth(2020, 19));
        assertEquals("Invalid month value: 19", exception.getMessage());
    }


}
