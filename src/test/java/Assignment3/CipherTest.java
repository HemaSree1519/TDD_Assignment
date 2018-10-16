package Assignment3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CipherTest {
    Cipher cipher = new Cipher();

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
        assertEquals('X', cipher.decrypt("X1"));
    }
}
