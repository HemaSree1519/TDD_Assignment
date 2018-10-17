package Assignment3;

class Cipher {
    private static int ZERO = 0;
    char currentLetter;
    int currentLetterCount = ZERO;

    public String encrypt(String plainText) {
        String plainText1 = plainText;
        String cipherText = "";
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
}
