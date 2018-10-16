package Assignment3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CipherTest {
    Cipher cipher = new Cipher();

    @Test
    public void returnLetteraFora() {
        assertEquals("a", cipher.encrypt("a"));
    }

    @Test
    public void returnSameLetter() {
        assertEquals("M", cipher.encrypt("M"));
    }

    @Test
    public void returnNumberOfLetters() {
        assertEquals("3", cipher.encrypt("aaa"));
    }
}
