package Assignment3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CipherTest {
    private Cipher cipher = new Cipher();
    private Cipher2 cipher2 = new Cipher2();

    @Test
    public void returnLettera1Fora() {
        assertEquals("a1", cipher.encrypt("a"));
    }

    @Test
    public void returnNumberOfLetters() {
        assertEquals("a3", cipher.encrypt("aaa"));
    }

    @Test
    public void returnCharCountOfString() {
        assertEquals("a2b3z1d2", cipher.encrypt("aabbbzdd"));
    }

    @Test
    public void returnXForX1() {
        assertEquals("X", cipher2.decrypt("X1"));
    }

    @Test
    public void returnDecodedMessage() {
        assertEquals("ffmmm", cipher2.decrypt("f2m3"));
    }
}
