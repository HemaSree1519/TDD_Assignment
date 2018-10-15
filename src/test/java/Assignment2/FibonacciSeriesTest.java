package Assignment2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciSeriesTest {
    FibonacciSeries fibonacciSeries = new FibonacciSeries();

    @Test
    public void ShouldReturnZeroForOne() {
        Assert.assertEquals(0, fibonacciSeries.nthNumber(1));
    }

    @Test
    public void shouldReturnOneForTwo() {
        Assert.assertEquals(1, fibonacciSeries.nthNumber(2));
    }

    @Test
    public void shouldReturnOneForThree() {
        Assert.assertEquals(1, fibonacciSeries.nthNumber(3));
    }

    @Test
    public void shouldReturnTwoForFour() {
        Assert.assertEquals(2, fibonacciSeries.nthNumber(4));
    }

    @Test
    public void shouldReturn4181For20() {
        Assert.assertEquals(4181, fibonacciSeries.nthNumber(20));
    }
}
