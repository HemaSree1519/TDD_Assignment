import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

public class NumberTest {
    NumberDemo number= new NumberDemo();

    @Test
    public void returnFalseForOne()
    {
        assertFalse(number.isPrime(1));
    }
}
