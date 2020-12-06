import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MainTest {

    Main unitToTest = new Main();

    @Test
    public void getProductOfExpenseReport() {
        List<Long> expenseList = List.of(1721L,
                979L,
                366L,
                299L,
                675L,
                1456L);

        long result = unitToTest.getProductOfExpenseReport(expenseList);
        assertEquals(241861950, result);

    }
}