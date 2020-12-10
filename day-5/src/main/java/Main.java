import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    private static final String INPUT = "input";

    public static void main(String[] args) {
        final var input = readFile();

      /* PART 1
        var result = input.map(Main::getSeatID)
                .max(Integer::compareTo)
                .get();
        System.out.println(result);
       */

        var sortedIDs = readFile().map(Main::getSeatID)
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());

        for (int i = 0; i < sortedIDs.size() - 1; i++) {
            if (sortedIDs.get(i + 1) - sortedIDs.get(i) != 1) {
                System.out.println(sortedIDs.get(i) + 1);
            }
        }
    }

    public static int getRow(String code) {
        List<Integer> binaryString = getBinaryList(code, 'F');
        return traverseBinaryCode(binaryString, 64);
    }

    private static List<Integer> getBinaryList(String code, char letter) {
        return code.chars()
                .map(current -> {
                    if ((char) current == letter) {
                        return 0;
                    } else {
                        return 1;
                    }
                })
                .boxed()
                .collect(Collectors.toList());
    }

    public static int traverseBinaryCode(List<Integer> code, int binaryPosition) {
        if (binaryPosition == 1) {
            if (code.get(0) == 1) {
                return 1;
            } else {
                return 0;
            }
        }
        if (code.get(0) == 1) {
            return binaryPosition + traverseBinaryCode(code.subList(1, code.size()), binaryPosition / 2);
        }
        return traverseBinaryCode((code.subList(1, code.size())), binaryPosition / 2);
    }

    public static int getColumn(String code) {
        List<Integer> binaryList = getBinaryList(code, 'L');
        return traverseBinaryCode(binaryList, 4);
    }

    public static int getSeatID(String input) {

        return getRow(input.substring(0, 7)) * 8 + getColumn(input.substring(7, 10));
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