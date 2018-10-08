public class FibonacciSeries {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;

    public int nthNumber(int index) {
        if (index == ONE) {
            return ZERO;
        } else if (index == TWO || index == THREE) {
            return ONE;
        } else {
            return nthNumber(index - 1) + nthNumber(index - 2);
        }
    }
}
