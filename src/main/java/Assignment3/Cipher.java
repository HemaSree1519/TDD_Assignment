package Assignment3;

public class Cipher {
    private static int ZERO = 0;
    private String plainText;
    private String cipherText;
    char currentLetter;
    int currentLetterCount = ZERO;

    public String encrypt(String plainText) {
        this.plainText = plainText;
        cipherText = "";
        currentLetter = plainText.charAt(ZERO);
        for (int index = ZERO; index < plainText.length(); index++) {
            if (plainText.charAt(index) == currentLetter) {
                currentLetterCount++;
            } else {
                cipherText = cipherText + currentLetter + currentLetterCount;
                currentLetter = plainText.charAt(index);
                currentLetterCount = 1;
            }
        }
        cipherText = cipherText + currentLetter + currentLetterCount;
        return cipherText;
    }

    public String decrypt(String cipherText) {
        this.cipherText = cipherText;
        plainText = "";
        currentLetter = cipherText.charAt(ZERO);
        for (int index = ZERO; index < cipherText.length(); index++) {
            if (Character.isDigit(cipherText.charAt(index))) {
                currentLetterCount = Character.getNumericValue(cipherText.charAt(index));
                for (int index2 = ZERO; index2 < currentLetterCount; index2++) {
                    plainText = plainText + currentLetter;
                }
            } else {
                currentLetter = cipherText.charAt(index);
            }
        }
        return plainText;
    }
}
