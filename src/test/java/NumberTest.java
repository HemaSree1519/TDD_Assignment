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
}
