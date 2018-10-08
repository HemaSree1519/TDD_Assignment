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

    @Test
    public void returnBuzzFor5Multiples() {
        assertEquals("Buzz", fizzBuzzObject.fizzOrBuzz(10));
    }

    @Test
    public void returnsFizzBuzzFor3And5Multilples() {
        assertEquals("FizzBuzz", fizzBuzzObject.fizzOrBuzz(15));
    }

    @Test
    public void returnSameNumberIfNotFizzOrBuzzOrFizzBuzz() {
        assertEquals("7", fizzBuzzObject.fizzOrBuzz(7));
    }
}
