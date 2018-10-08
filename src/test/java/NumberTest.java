import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NumberTest {

    NumberDemo number= new NumberDemo();

    @Test
    public void returnFalseForOne()
    {
        assertFalse(number.isPrime(1));
    }

}
