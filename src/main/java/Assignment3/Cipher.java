package Assignment3;

public class Cipher {
    private String plainText;

    public String encrypt(String inputText) {
        this.plainText = inputText;
        int numberOfLetters = plainText.length();
        return Integer.toString(numberOfLetters);
    }
}
