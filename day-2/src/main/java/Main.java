import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    private static final String INPUT = "input";

    public static void main(String[] args) {
        var passwordList = readFile().collect(Collectors.toList());
        var result = validPasswords(passwordList);
        System.out.println(result);
    }

    public static long validPasswords(List<String> passwordList) {
        return passwordList.stream().filter(Main::checkValidity).count();
    }

    public static boolean checkValidity(String input) {
        var lower = getLowerBound(input);
        var upper = getUpperBound(input);
        var letter = getLetter(input);
        var password = getPassword(input);

        return isAtPosition(lower, letter, password) ^ (isAtPosition(upper, letter, password));
    }

    private static boolean isAtPosition(int position, char letter, String password) {
        try {
            return letter == password.charAt(position - 1);
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static int getLowerBound(String input) {
        var lower = input.split(" ")[0].split("-")[0];
        return Integer.parseInt(lower);
    }

    public static int getUpperBound(String input) {
        var upper = input.split(" ")[0].split("-")[1];
        return Integer.parseInt(upper);
    }

    public static char getLetter(String input) {
        return input.split(" ")[1].charAt(0);
    }

    public static String getPassword(String input) {
        return input.split(" ")[2];
    }

    private static Stream<String> readFile() {
        try {
            return Files.lines(Paths.get(INPUT));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}