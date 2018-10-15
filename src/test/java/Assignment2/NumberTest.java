package Assignment2;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class NumberTest {
    NumberDemo number = new NumberDemo();

    @Test
    public void returnFalseForOne() {
        TestCase.assertFalse(number.isPrime(1));
    }

    @Test
    public void returnTrueForTwo() {
        TestCase.assertTrue(number.isPrime(2));
    }

    @Test
    public void returnTrueForThree() {
        TestCase.assertTrue(number.isPrime(3));
    }

    @Test
    public void returnFalseForFour() {
        TestCase.assertFalse(number.isPrime(4));
    }

    @Test
    public void returnTrueForFive() {
        TestCase.assertTrue(number.isPrime(5));
    }

    @Test
    public void returnFalseForNine() {
        TestCase.assertFalse(number.isPrime(9));
    }
}
