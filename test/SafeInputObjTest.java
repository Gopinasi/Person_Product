import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SafeInputObjTest {
    SafeInputObj test;
    SafeInputObj testString;
    SafeInputObj testNum;
    SafeInputObj testDouble;
    SafeInputObj testBool;
    String str = "Hello, this is Module 2 for Computer Programming II";
    String num = "15\n";
    String doub = "12.5\n";
    String bool = "Y\n";

   @BeforeEach
   void setUp() {
       test = new SafeInputObj();
       testString = new SafeInputObj(new Scanner(str));
       testNum = new SafeInputObj(new Scanner(num));
       testDouble = new SafeInputObj(new Scanner(doub));
       testBool = new SafeInputObj(new Scanner(bool));
   }

    @Test
    void testGetNonZeroLenString() {
        String result = testString.getNonZeroLenString("Enter a non-empty string: ");
        assertEquals(str, result);
    }

    @Test
    void testGetMinLenString() {
        String result = testString.getMinLenString("Enter a non-empty String", 30);
        assertEquals(str, result);
    }

    @Test
    void testGetRangedInt() {
        int result = testNum.getRangedInt("Enter a number", 10, 30);
        assertEquals(15, result);

    }

    @Test
    void testGetInt() {
       int result = testNum.getInt("Enter a number");
       assertEquals(15, result);
    }

    @Test
    void testGetRangedDouble() {
       double result = testDouble.getRangedDouble("Enter a number", 5, 20);
       assertEquals(12.5, result);
    }

    @Test
    void testGetDouble() {
       double result = testDouble.getDouble("Enter a number");
       assertEquals(12.5, result);
    }

    @Test
    void testGetYNConfirm() {
       boolean result = testBool.getYNConfirm("Enter prompt");
       assertEquals(true, result);
    }

    @Test
    void testGetRegExString() {
       String result = testString.getRegExString("Enter prompt", "^.+$");
       assertEquals(str, result);

    }
}