public class NumberDemo {
private static final int ONE =1;
private static final int TWO=2;
private static final int ZERO=0;
    public boolean isPrime(int inputNumber) {
        if(inputNumber == ONE) {
            return false;
        }
        if(inputNumber == TWO) {
            return true;
        }
        for(int index=TWO;index <= inputNumber / TWO; index++)
        {
            if(inputNumber % index == ZERO)
            {
                return false;
            }
        }
        return true;
    }
}
