import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    private static final String INPUT = "input";

    public static void main(String[] args) {
        final var input = readFile()
                .collect(Collectors.joining("\n"))
                .split("\n{2}");

        long count = Arrays.stream(input)
                .map(Passport::new)
                .filter(Passport::validate)
                .count();

        System.out.println(count);
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