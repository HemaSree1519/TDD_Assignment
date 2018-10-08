import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    FizzBuzz fizzBuzzObject = new FizzBuzz();

    @Test
    public void returnsOneForOne() {
        assertEquals("1", fizzBuzzObject.fizzOrBuzz(1));
    }

    @Test
    public void returnFizzFor3() {
        assertEquals("Fizz", fizzBuzzObject.fizzOrBuzz(3));
    }

    @Test
    public void returnBuzzFor5() {
        assertEquals("Buzz", fizzBuzzObject.fizzOrBuzz(5));
    }

    @Test
    public void returnFizzFor3Multiples() {
        assertEquals("Fizz", fizzBuzzObject.fizzOrBuzz(6));
    }
}
