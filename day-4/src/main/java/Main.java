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