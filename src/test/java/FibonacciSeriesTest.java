import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciSeriesTest {
    FibonacciSeries fibonacciSeries = new FibonacciSeries();

    @Test
    public void ShouldReturnZeroForOne() {
        assertEquals(0, fibonacciSeries.nthNumber(1));
    }

    @Test
    public void shouldReturnOneForTwo() {
        assertEquals(1, fibonacciSeries.nthNumber(2));
    }

    @Test
    public void shouldReturnOneForThree() {
        assertEquals(1, fibonacciSeries.nthNumber(3));
    }

    @Test
    public void shouldReturnTwoForFour() {
        assertEquals(2, fibonacciSeries.nthNumber(4));
    }


}
