import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciSeriesTest {
    FibonacciSeries fibonacciSeries = new FibonacciSeries();

    @Test
    public void ShouldReturnOneForOne() {
        assertEquals(1, fibonacciSeries.nthNumber(1));
    }

}
