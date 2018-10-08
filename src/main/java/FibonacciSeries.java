public class FibonacciSeries {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;

    public int nthNumber(int index) {
        if (index == ONE) {
            return ZERO;
        } else if (index == TWO) {
            return ONE;
        } else {
            return nthNumber(index - 1) + nthNumber(index - 2);
        }
    }
}
