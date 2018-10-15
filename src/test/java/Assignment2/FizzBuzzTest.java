package Assignment2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    FizzBuzz fizzBuzzObject = new FizzBuzz();

    @Test
    public void returnsOneForOne() {
        Assert.assertEquals("1", fizzBuzzObject.fizzOrBuzz(1));
    }

    @Test
    public void returnFizzFor3() {
        Assert.assertEquals("Fizz", fizzBuzzObject.fizzOrBuzz(3));
    }

    @Test
    public void returnBuzzFor5() {
        Assert.assertEquals("Buzz", fizzBuzzObject.fizzOrBuzz(5));
    }

    @Test
    public void returnFizzFor3Multiples() {
        Assert.assertEquals("Fizz", fizzBuzzObject.fizzOrBuzz(6));
    }

    @Test
    public void returnBuzzFor5Multiples() {
        Assert.assertEquals("Buzz", fizzBuzzObject.fizzOrBuzz(10));
    }

    @Test
    public void returnsFizzBuzzFor3And5Multilples() {
        Assert.assertEquals("Assignment2.FizzBuzz", fizzBuzzObject.fizzOrBuzz(15));
    }

    @Test
    public void returnSameNumberIfNotFizzOrBuzzOrFizzBuzz() {
        Assert.assertEquals("7", fizzBuzzObject.fizzOrBuzz(7));
    }
}
