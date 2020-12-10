import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassportTest {

    @Test
    public void testValidate() {

    }



    @Test
    public void tesConstruct_incompleteFields_shouldConstructPassport() {
        String input = "hcl:#ae17e1 iyr:2013\n" +
                "eyr:2024\n" +
                "ecl:brn pid:760753108 byr:1931\n" +
                "hgt:179cm";

        Passport actualPassport = new Passport(input);

        assertEquals("#ae17e1", actualPassport.getHairColor());
        assertEquals("2013", actualPassport.getIssueYear());
        assertEquals("2024", actualPassport.getExpireYear());
        assertEquals("brn", actualPassport.getEyeColor());
        assertEquals("760753108L", actualPassport.getPassportId());
        assertEquals("1931", actualPassport.getBirthYear());
        assertEquals("179cm", actualPassport.getHeight());
    }

        @Test
        public void testConstruct_completeFields_shouldConstructPassport () {
            String input = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n" +
                    "byr:1937 iyr:2017 cid:147 hgt:183cm";

            Passport actualPassport = new Passport(input);
            assertEquals("1937", actualPassport.getBirthYear());
            assertEquals("gry", actualPassport.getEyeColor());
            assertEquals("2020", actualPassport.getExpireYear());
            assertEquals("#fffffd", actualPassport.getHairColor());
            assertEquals("183cm", actualPassport.getHeight());
        }

    @Test
    public void validateRange() {
        assertTrue(Passport.validateRange("1945", 1920, 2002));
        assertTrue(Passport.validateRange("2002", 1920, 2002));
        assertTrue(Passport.validateRange("1920", 1920, 2002));
        assertFalse(Passport.validateRange("1919", 1920, 2002));
        assertFalse(Passport.validateRange("19999", 1920, 2002));
        assertFalse(Passport.validateRange("2003", 1920, 2002));
    }
}