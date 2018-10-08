public class NumberDemo {
private static final int ONE =1;
private static final int TWO=2;
private static final int THREE=3;
    public boolean isPrime(int inputNumber) {
        if (inputNumber == ONE) {
            return false;
        }
        if(inputNumber == TWO) {
            return true;
        }
        if(inputNumber == THREE) {
            return true;
        }
        return false;
    }
}
