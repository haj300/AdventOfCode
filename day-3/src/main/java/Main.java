import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {

    private static final String INPUT = "input";
    private static char[][] array;
    private static int rows;
    private static int columns;

    public static void main(String[] args) {
        fillArray();
        long collision1 = goToAirport(1, 1);
        long collision2 = goToAirport(3, 1);
        long collision3 = goToAirport(5, 1);
        long collision4 = goToAirport(7, 1);
        long collision5 = goToAirport(1, 2);

        System.out.println(collision1 * collision2 * collision3 * collision4 * collision5);
    }

    private static int goToAirport(int sideSteps, int downSteps) {
        int row = 0;
        int column = 0;
        int collisionCnt = 0;

        while(true) {
            if(column + sideSteps >= columns){
                column = columns - column;
                column = sideSteps - column;
            } else {
                column +=sideSteps;
            }

            row += downSteps;

            if(row >= rows){
                break;
            }

            if(array[row][column] == '#'){
                collisionCnt++;
            }
        }
        return collisionCnt;
    }

    private static void fillArray() {
        rows = (int) readFile().count();
        columns = readFile().findFirst().get().length();
        array = new char[rows][columns];

        AtomicInteger index = new AtomicInteger();
        readFile().forEach(row -> {array[index.getAndIncrement()] = row.toCharArray(); });
        System.out.println();
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