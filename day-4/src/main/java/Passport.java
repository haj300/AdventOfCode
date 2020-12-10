import java.util.Arrays;

public class Passport {

    String birthYear;
    String issueYear;
    String expireYear;
    String height;
    String hairColor;
    String eyeColor;
    String passportId;
    String countryId;

    public Passport(String passport){
        final var fields = passport.split("\\s+");

        Arrays.stream(fields).forEach(this::insertField);
    }

    public boolean validate() {
        var birthYearValid = birthYear != null && birthYear.length() == 4 && validateRange(birthYear, 1920, 2002);
        var issueYearValid = issueYear != null && issueYear.length() == 4 && validateRange(issueYear, 2010, 2020);
        var expirationYearValid =
                expireYear != null && expireYear.length() == 4 && validateRange(expireYear, 2020, 2030);
        var heightValid = validateHeight(height);
        var hairColorValid = hairColor != null && hairColor.matches("#[a-z0-9]{6}");
        var eyeColorValid = eyeColor != null && Arrays.stream(new String[]{"amb", "blu", "brn", "gry", "grn", "hzl", "oth"})
                .anyMatch(eyeColor::equalsIgnoreCase);
        var passportIdValid = passportId != null && passportId.matches("[0-9]{9}");

        return birthYearValid && issueYearValid && expirationYearValid && heightValid && hairColorValid && eyeColorValid && passportIdValid;
    }

    static boolean validateHeight(String height) {
        if (height == null) {
            return false;
        }
        if (height.endsWith("in")) {
            int inchHeight = Integer.parseInt(height.split("in")[0]);
            return inchHeight >= 59 && inchHeight <= 76;
        } else if (height.endsWith("cm")) {
            int centimeterHeight = Integer.parseInt(height.split("cm")[0]);
            return centimeterHeight >= 150 && centimeterHeight <= 193;
        } else {
            return false;
        }
    }

    static boolean validateRange(String value, int lowerBound, int upperBound) {
        int comparingValue = Integer.parseInt(value);
        return comparingValue >= lowerBound && comparingValue <= upperBound;
    }

   /* public boolean validate(){
        boolean byrValid = birthYear.length() == 4 && validateRange(birthYear, 1920, 2002);

        return birthYear != null &&
                issueYear != null &&
                expireYear != null &&
                height != null &&
                hairColor != null &&
                eyeColor != null &&
                passportId != null;
    }

    static boolean validateRange(String field, int lowerBound, int upperBound) {
        int comparingValue = Integer.valueOf(field).intValue();
        return comparingValue >= lowerBound && comparingValue <= upperBound;
    }*/

    private void insertField(String field){
        final var keyAndValue = field.split(":");

        switch (keyAndValue[0]){
            case "byr":
                setBirthYear(keyAndValue[1]);
                break;
            case "iyr":
                setIssueYear(keyAndValue[1]);
                break;
            case "eyr":
                setExpireYear(keyAndValue[1]);
                break;
            case "hgt":
                setHeight(keyAndValue[1]);
                break;
            case "hcl":
                setHairColor(keyAndValue[1]);
                break;
            case "ecl":
                setEyeColor(keyAndValue[1]);
                break;
            case "pid":
                setPassportId(keyAndValue[1]);
                break;
            case "cid":
                setCountryId(keyAndValue[1]);
                break;
        }
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(String issueYear) {
        this.issueYear = issueYear;
    }

    public String getExpireYear() {
        return expireYear;
    }

    public void setExpireYear(String expireYear) {
        this.expireYear = expireYear;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }
}
