public class FizzBuzz {
private static final int THREE=3;
private static final int FIVE=5;
private static final int ZERO = 0;
    public String fizzOrBuzz(int inputNumber) {
        if(inputNumber % THREE == ZERO)
        {
            return "Fizz";
        }
        else if(inputNumber % FIVE == ZERO)
        {
            return "Buzz";
        }
        return "1";

    }
}
