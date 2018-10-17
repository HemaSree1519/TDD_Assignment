package Assignment3;

class Cipher2 {
    private static int ZERO = 0;
    char currentLetter;
    int currentLetterCount = ZERO;

    public String decrypt(String cipherText) {
        String cipherText1 = cipherText;
        String plainText = "";
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
