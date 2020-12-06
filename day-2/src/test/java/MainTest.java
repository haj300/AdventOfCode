import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void validPasswords() {
        List<String> passwords = List.of("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");
        long result = Main.validPasswords(passwords);
        assertEquals(1, result);
    }

    @Test
    public void checkValidity_valid(){
        assertTrue(Main.checkValidity("1-4 f: abcf"));
    }

    @Test
    public void checkValidity_notValid(){
        assertFalse(Main.checkValidity("1-4 f: abcrf"));
    }

    @Test
    public void checkValidity_notValidBothMatch(){
        assertFalse(Main.checkValidity("1-4 f: fbcf"));
    }

    @Test
    public void getLowerBound() {
        assertEquals(1, Main.getLowerBound("1-3 a: abcde"));
        assertEquals(17, Main.getLowerBound("17-18 d: ddddddd"));
    }

    @Test
    public void getUpperBound() {
        assertEquals(3, Main.getUpperBound("1-3 a: abcde"));
        assertEquals(18, Main.getUpperBound("17-18 d: ddddddd"));
    }

    @Test
    public void getPassword() {
        assertEquals("abcde", Main.getPassword("1-3 a: abcde"));
    }

    @Test
    public void getLetter() {
        assertEquals('a', Main.getLetter("1-3 a: abcde"));

    }
}