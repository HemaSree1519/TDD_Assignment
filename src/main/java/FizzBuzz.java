public class FizzBuzz {
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final int ZERO = 0;

    public String fizzOrBuzz(int inputNumber) {
        if (inputNumber % THREE == ZERO && inputNumber % FIVE == ZERO) {
            return "FizzBuzz";
        } else if (inputNumber % FIVE == ZERO) {
            return "Buzz";
        } else if (inputNumber % THREE == ZERO) {
            return "Fizz";
        } else {
            return Integer.toString(inputNumber);
        }

    }
}
