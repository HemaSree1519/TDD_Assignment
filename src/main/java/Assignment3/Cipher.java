package Assignment3;

public class Cipher {
    private static int ZERO = 0;
    private String plainText;
    private String cipherText;

    public String encrypt(String plainText) {
        this.plainText = plainText;
        cipherText = "";
        int CurrentLetterCount = ZERO;
        char currentLetter = plainText.charAt(ZERO);
        for (int index = ZERO; index < plainText.length(); index++) {
            if (plainText.charAt(index) == currentLetter) {
                CurrentLetterCount++;
            } else {
                cipherText = cipherText + currentLetter + CurrentLetterCount;
                currentLetter = plainText.charAt(index);
                CurrentLetterCount = 1;
            }
        }
        cipherText = cipherText + currentLetter + CurrentLetterCount;
        return cipherText;
    }

    public char decrypt(String cipherText) {
        return 'X';
    }
}
