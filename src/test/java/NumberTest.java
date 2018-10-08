import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class NumberTest {
    NumberDemo number= new NumberDemo();

    @Test
    public void returnFalseForOne()
    {
        assertFalse(number.isPrime(1));
    }

    @Test
    public void returnTrueForTwo()
    {
        assertTrue(number.isPrime(2));
    }

    @Test
    public void returnTrueForThree()
    {
        assertTrue(number.isPrime(3));
    }

    @Test
    public void returnFalseForFour()
    {
        assertFalse(number.isPrime(4));
    }

    @Test
    public void returnTrueForFive()
    {
        assertTrue(number.isPrime(5));
    }
}
