import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    FizzBuzz fizzBuzzObject = new FizzBuzz();
    @Test
    public void returnsOneForOne()
    {
        assertEquals("1",fizzBuzzObject.fizzOrBuzz(1));
    }

    @Test
    public void returnFizzFor3()
    {
        assertEquals("Fizz",fizzBuzzObject.fizzOrBuzz(3));
    }
}
