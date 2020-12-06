import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    private static final String INPUT = "input";

    public static void main(String[] args) {
        List<Long> expenseList = readFile().map(Long::valueOf).collect(Collectors.toList());
        long result = getProductOfExpenseReport(expenseList);
        System.out.println(result);
    }

    public static long getProductOfExpenseReport(List<Long> expenseList) {
        for (int i = 0; i < expenseList.size(); i++) {
            Long currentI = expenseList.get(i);
            for (int j = i + 1; j < expenseList.size(); j++) {
                Long currentJ = expenseList.get(j);
                for (int d = j + 1; d < expenseList.size() ; d++) {
                    if (currentI + expenseList.get(d) + currentJ == 2020) {
                        return currentI * currentJ * expenseList.get(d);
                    }
                }
            }
        }
        return 0;
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
